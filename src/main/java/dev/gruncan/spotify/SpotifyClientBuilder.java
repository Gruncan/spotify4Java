package dev.gruncan.spotify;

import dev.gruncan.http.HttpMethod;
import dev.gruncan.http.HttpRequest;
import dev.gruncan.http.HttpResponse;
import dev.gruncan.http.SpotifyHttpServerProvider;
import dev.gruncan.json.JSONObject;
import dev.gruncan.spotify.webapi.requests.SpotifyRequest;
import dev.gruncan.spotify.webapi.requests.SpotifyRequestExecutor;
import dev.gruncan.spotify.webapi.requests.SpotifyRequestVariant;
import dev.gruncan.spotify.webapi.requests.util.Scope;
import dev.gruncan.spotify.util.Util;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class SpotifyClientBuilder {


    private final static String AUTH_URL = "https://accounts.spotify.com/authorize";
    private final static String TOKEN_URL = "https://accounts.spotify.com/api/token";

    private final String clientID;
    private final String clientSecret;
    private final String redirectUriString;
    private final URL redirectUrl;
    private final List<Scope> scopeList;
    private String responseType;
    private String state;
    private boolean showDialog;

    private long timeWhenRefresh;
    private String refreshToken;
    private String encoding;

    private SpotifyClient builtClient;
    private SpotifyHttpServerProvider spotifyHttpServerProvider;
    private boolean printAccessToken;
    private boolean enforceScopeCheck;


    public SpotifyClientBuilder(String clientID, String clientSecret, String redirectUri) {
        this.clientID = clientID;
        this.clientSecret = clientSecret;
        this.redirectUriString = redirectUri;
        this.scopeList = new ArrayList<>();
        this.responseType = "code";
        this.state = null;
        this.showDialog = false;
        this.timeWhenRefresh = -1;
        this.refreshToken = null;
        this.builtClient = null;
        this.printAccessToken = false;
        this.enforceScopeCheck = true;

        try {
            this.redirectUrl = new URL(redirectUri);
        } catch (MalformedURLException e) {
            throw new RuntimeException();
        }
    }


    public URL getRedirectUrl() {
        return this.redirectUrl;
    }

    public SpotifyClientBuilder addScope(Scope... scope) {
        this.scopeList.addAll(Arrays.asList(scope));
        return this;
    }


    public SpotifyClientBuilder setResponseType(String type) {
        this.responseType = type;
        return this;
    }

    public SpotifyClientBuilder setState(String state) {
        this.state = state;
        return this;
    }

    public SpotifyClientBuilder setShowDialog(boolean b) {
        this.showDialog = b;
        return this;
    }

    public SpotifyClientBuilder setEnforceScopeCheck(boolean b){
        this.enforceScopeCheck = b;
        return this;
    }

    public static SpotifyClient buildFromToken(String token) {
        return new SpotifyClientImp(token, null);
    }


    public String buildAuthUrl() {
        Map<String, String> map = new HashMap<>() {{
            put("client_id", clientID);
            put("response_type", responseType);
            put("redirect_uri", redirectUriString);
            put("scope", Util.join(Scope.convertToStringArray(scopeList), "%20"));
            put("show_dialog", Boolean.toString(showDialog));
        }};

        if (state != null)
            map.put("state", this.state);

        String query = Util.mapToQuery(map);
        return AUTH_URL + query;
    }

    public SpotifyClient getBuiltClient() {
        this.spotifyHttpServerProvider = new SpotifyHttpServerProvider(this);
        this.spotifyHttpServerProvider.runServer();
        try {
            this.spotifyHttpServerProvider.getCountDownLatch().await();
            return this.builtClient;
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }

    }


    public SpotifyClient build(String code) {
        Map<String, String> queries = new HashMap<>() {{
            put("grant_type", "authorization_code");
            put("code", code);
            put("redirect_uri", redirectUriString);
        }};

        this.encoding = new String(Base64.getEncoder().encode((this.clientID + ":" + this.clientSecret)
                .getBytes(StandardCharsets.UTF_8)));

        HttpResponse entity = this.sendPostTokenRequest(queries);
        if (entity != null) {
            this.builtClient = this.getSpotifyClient(entity);
            return this.builtClient;
        } else {
            return null;
        }
    }


    public SpotifyClient refreshToken() {
        if (this.refreshToken == null) {
            System.out.println("Refresh token not set, call build first");
            return null;
        }
        Map<String, String> queries = new HashMap<>() {{
            put("grant_type", "refresh_token");
            put("refresh_token", refreshToken);
        }};

        HttpResponse response = this.sendPostTokenRequest(queries);

        if (response != null) {
            this.builtClient = this.getSpotifyClient(response);
            return this.builtClient;
        } else {
            return null;
        }
    }

    public SpotifyClientBuilder printAccessToken() {
        this.printAccessToken = true;
        return this;
    }

    private SpotifyClient getSpotifyClient(HttpResponse response) {

        JSONObject jsonObject = new JSONObject(response.getContent());
        String token = jsonObject.getString("access_token");
        if (printAccessToken)
            System.out.println(token);
        int expiresIn = jsonObject.getInt("expires_in");
        this.timeWhenRefresh = System.currentTimeMillis() + (expiresIn * 1000L);
        this.refreshToken = jsonObject.getString("refresh_token");

        if (this.enforceScopeCheck)
            return new SpotifyClientImp(token, this.scopeList);
        else
            return new SpotifyClientImp(token, null);

    }

    private HttpResponse sendPostTokenRequest(Map<String, String> queries) {
        HttpRequest httpRequest = new HttpRequest(TOKEN_URL, HttpMethod.POST);
        httpRequest.addRequestQueries(queries);

        httpRequest.addRequestHeader("Content-type", "application/x-www-form-urlencoded");
        httpRequest.addRequestHeader("Authorization", "Basic " + this.encoding);

        return httpRequest.execute();
    }


    private final static class SpotifyClientImp extends SpotifyRequestExecutor implements SpotifyClient {

        private final String accessToken;
        private final List<Scope> scopes;

        public SpotifyClientImp(String accessToken, List<Scope> scopes) {
            this.accessToken = accessToken;
            this.scopes = scopes;
        }


        @Override
        public SpotifyResponse executeRequest(SpotifyRequestVariant request) {
            SpotifyRequest spotifyRequest = request.getClass().getAnnotation(SpotifyRequest.class);
            if (spotifyRequest == null) {
                System.out.printf("Failed to execute %s, no request is annotated.", request.getClass().getName());
                return null;
            }
            if (this.scopes != null) {
                for (Scope scope : spotifyRequest.authorizations()) {
                    if (!this.scopes.contains(scope)) {
                        System.out.printf("Failed to execute %s, client does not have required scopes %s%n",
                                request.getClass().getName(), Arrays.toString(spotifyRequest.authorizations()));
                        return null;
                    }
                }
            }
            return super.execute(this.accessToken, request);
        }
    }
}

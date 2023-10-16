package dev.gruncan.spotify;

import dev.gruncan.http.HttpMethod;
import dev.gruncan.http.HttpRequest;
import dev.gruncan.http.HttpResponse;
import dev.gruncan.http.SpotifyHttpServerProvider;
import dev.gruncan.json.JSONObject;
import dev.gruncan.spotify.api.SpotifyAPIType;
import dev.gruncan.spotify.api.SpotifyRequest;
import dev.gruncan.spotify.api.SpotifyRequestExecutor;
import dev.gruncan.spotify.api.SpotifyRequestVariant;
import dev.gruncan.spotify.api.ads.requests.SpotifyAdRequestExecutor;
import dev.gruncan.spotify.api.web.requests.SpotifyWebRequestExecutor;
import dev.gruncan.spotify.api.web.requests.util.Scope;
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
    private SpotifyAPIType type;

    private long timeWhenRefresh;
    private String refreshToken;
    private String encoding;

    private SpotifyClient builtClient;
    private SpotifyHttpServerProvider spotifyHttpServerProvider;
    private boolean printAccessToken;
    private boolean enforceScopeCheck;


    public SpotifyClientBuilder(String clientID, String clientSecret, String redirectUri) {
        this(clientID, clientSecret, redirectUri, SpotifyAPIType.WEB);
    }

    public SpotifyClientBuilder(String clientID, String clientSecret, String redirectUri, SpotifyAPIType type){
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
        this.type = type;

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

    public SpotifyClientBuilder setApiType(SpotifyAPIType type){
        if(type != this.type) {
            this.type = type;
            // If type changes must reauthenticate
            this.builtClient = null;
        }
        return this;
    }

    public static SpotifyClient buildFromToken(String token, SpotifyAPIType type) {
        return new SpotifyClientImp(token, null, SpotifyClientBuilder.getRequestExecutor(type));
    }

    public static SpotifyClient buildFromToken(String token) {
        return SpotifyClientBuilder.buildFromToken(token, SpotifyAPIType.WEB);
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
        if (this.builtClient != null){
            return this.builtClient;
        }
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

        SpotifyRequestExecutor requestExecutor = SpotifyClientBuilder.getRequestExecutor(this.type);
        if (this.enforceScopeCheck)
            return new SpotifyClientImp(token, this.scopeList, requestExecutor);
        else
            return new SpotifyClientImp(token, null, requestExecutor);
    }

    private HttpResponse sendPostTokenRequest(Map<String, String> queries) {
        HttpRequest httpRequest = new HttpRequest(TOKEN_URL, HttpMethod.POST);
        httpRequest.addRequestQueries(queries);

        httpRequest.addRequestHeader("Content-type", "application/x-www-form-urlencoded");
        httpRequest.addRequestHeader("Authorization", "Basic " + this.encoding);

        return httpRequest.execute();
    }

    private static SpotifyRequestExecutor getRequestExecutor(SpotifyAPIType type){
        switch (type){
            case WEB -> {
                return new SpotifyWebRequestExecutor();
            }
            case ADS -> {
                return new SpotifyAdRequestExecutor();
            }
            default -> {
                return null;
            }
        }
    }

    private final static class SpotifyClientImp implements SpotifyClient {

        private final String accessToken;
        private final List<Scope> scopes;
        private final SpotifyRequestExecutor requestExecutor;

        public SpotifyClientImp(String accessToken, List<Scope> scopes, SpotifyRequestExecutor requestExecutor) {
            this.accessToken = accessToken;
            this.scopes = scopes;
            this.requestExecutor = requestExecutor;
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
            return this.requestExecutor.execute(this.accessToken, request);
        }
    }
}

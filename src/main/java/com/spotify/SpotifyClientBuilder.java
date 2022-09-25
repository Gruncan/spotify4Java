package com.spotify;

import com.http.HttpMethod;
import com.http.HttpRequest;
import com.http.HttpResponse;
import com.spotify.json.JSONObject;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.util.Scope;
import com.spotify.util.Util;

import java.nio.charset.StandardCharsets;
import java.util.*;

public class SpotifyClientBuilder {


    private final static String AUTH_URL = "https://accounts.spotify.com/authorize";
    private final static String TOKEN_URL = "https://accounts.spotify.com/api/token";

    private final String clientID;
    private final String clientSecret;
    private final String redirectUri;
    private final List<Scope> scopeList;
    private String responseType;
    private String state;
    private boolean showDialog;

    private long timeWhenRefresh;
    private String refreshToken;
    private String encoding;

    private SpotifyClient builtClient;


    public SpotifyClientBuilder(String clientID, String clientSecret, String redirectUri) {
        this.clientID = clientID;
        this.clientSecret = clientSecret;
        this.redirectUri = redirectUri;
        this.scopeList = new ArrayList<>();
        this.responseType = "code";
        this.state = null;
        this.showDialog = false;
        this.timeWhenRefresh = -1;
        this.refreshToken = null;
        this.builtClient = null;
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


    public String buildAuthUrl() {
        Map<String, String> map = new HashMap<>() {{
            put("client_id", clientID);
            put("response_type", responseType);
            put("redirect_uri", redirectUri);
            put("scope", Util.join(Scope.convertToStringArray(scopeList), "%20"));
            put("show_dialog", Boolean.toString(showDialog));
        }};

        if (state != null)
            map.put("state", this.state);

        String query = Util.mapToQuery(map);
        return AUTH_URL + query;
    }

    public SpotifyClient getBuiltClient() {
        return this.builtClient;
    }


    public SpotifyClient build(String code) {
        Map<String, String> queries = new HashMap<>() {{
            put("grant_type", "authorization_code");
            put("code", code);
            put("redirect_uri", redirectUri);
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

    private SpotifyClient getSpotifyClient(HttpResponse response) {

        JSONObject jsonObject = new JSONObject(response.getMessage());
        String token = jsonObject.getString("access_token");
        int expiresIn = jsonObject.getInt("expires_in");
        this.timeWhenRefresh = System.currentTimeMillis() + (expiresIn * 1000L);
        this.refreshToken = jsonObject.getString("refresh_token");
        return new SpotifyClientImp(token);

    }

    private HttpResponse sendPostTokenRequest(Map<String, String> queries) {
        HttpRequest httpRequest = new HttpRequest(TOKEN_URL, HttpMethod.POST);
        httpRequest.addRequestQueries(queries);

        httpRequest.addRequestHeader("Content-type", "application/x-www-form-urlencoded");
        httpRequest.addRequestQuery("Authorization", "Basic " + this.encoding);

        return httpRequest.execute();


    }


    private static class SpotifyClientImp implements SpotifyClient {

        private final String accessToken;

        public SpotifyClientImp(String accessToken) {
            this.accessToken = accessToken;
        }


        @Override
        public JSONObject executeRequest(AbstractRequest abstractRequest) {
            return abstractRequest.execute(this.accessToken);
        }


    }


}

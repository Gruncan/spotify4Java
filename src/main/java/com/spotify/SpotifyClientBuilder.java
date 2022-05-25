package com.spotify;

import com.spotify.requests.util.Scope;
import com.spotify.util.Util;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.message.BasicNameValuePair;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public SpotifyClientBuilder(String clientID, String clientSecret, String redirectUri) {
        this.clientID = clientID;
        this.clientSecret = clientSecret;
        this.redirectUri = redirectUri;
        this.scopeList = new ArrayList<>();
        this.responseType = "code";
        this.state = null;
        this.showDialog = false;
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


    public SpotifyClient build() {

        try {
            URIBuilder authUri = new URIBuilder(AUTH_URL);
            List<NameValuePair> authParams = new ArrayList<>();
            authParams.add(new BasicNameValuePair("client_id", this.clientID));
            authParams.add(new BasicNameValuePair("response_type", this.responseType));
            authParams.add(new BasicNameValuePair("redirect_uri", this.redirectUri));
            String[] scopes = (String[]) this.scopeList.stream().map(Scope::getScopeString).toArray();
            authParams.add(new BasicNameValuePair("scope", Util.join(scopes, "%20")));
            authParams.add(new BasicNameValuePair("show_dialog", Boolean.toString(this.showDialog)));

            if (state != null)
                authParams.add(new BasicNameValuePair("state", this.state));

            authUri.addParameters(authParams);


            String authUrl = authUri.build().toString();
            List<NameValuePair> tokenParams = new ArrayList<>();
            tokenParams.add(new BasicNameValuePair("grant_type", "authorization_code"));
            tokenParams.add(new BasicNameValuePair("code", null));
            tokenParams.add(new BasicNameValuePair("redirect_uri", this.redirectUri));

            return new SpotifyClientImp(authUrl, TOKEN_URL);

        } catch (URISyntaxException e) {
            e.printStackTrace();
            return null;
        }


    }


    private static class SpotifyClientImp extends SpotifyClient {


        private final String authUrl;
        private final String accToken;
        private String code;

        public SpotifyClientImp(String authUrl, String accToken) {
            this.authUrl = authUrl;
            this.accToken = accToken;
        }
    }


}

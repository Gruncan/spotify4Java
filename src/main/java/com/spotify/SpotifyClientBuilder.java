package com.spotify;

import com.spotify.json.JSONObject;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.util.Scope;
import com.spotify.util.Util;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
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


    public String buildAuthUrl() {

        try {
            URIBuilder authUri = new URIBuilder(AUTH_URL);
            List<NameValuePair> authParams = new ArrayList<>();
            authParams.add(new BasicNameValuePair("client_id", this.clientID));
            authParams.add(new BasicNameValuePair("response_type", this.responseType));
            authParams.add(new BasicNameValuePair("redirect_uri", this.redirectUri));
            String[] scopes = Scope.convertToStringArray(this.scopeList);
            authParams.add(new BasicNameValuePair("scope", Util.join(scopes, "%20")));
            authParams.add(new BasicNameValuePair("show_dialog", Boolean.toString(this.showDialog)));

            if (state != null)
                authParams.add(new BasicNameValuePair("state", this.state));

            authUri.addParameters(authParams);

            return authUri.build().toString();

        } catch (URISyntaxException e) {
            e.printStackTrace();
            return null;
        }
    }


    public SpotifyClient build(String code) {
        List<NameValuePair> parameters = new ArrayList<>();
        parameters.add(new BasicNameValuePair("grant_type", "authorization_code"));
        parameters.add(new BasicNameValuePair("code", code));
        parameters.add(new BasicNameValuePair("redirect_uri", this.redirectUri));


        try {
            URIBuilder uriBuilder = new URIBuilder(TOKEN_URL);
            uriBuilder.addParameters(parameters);

            HttpClient httpClient = HttpClientBuilder.create().build();


            HttpPost httppost = new HttpPost(uriBuilder.build());
            httppost.setHeader("Content-type", "application/x-www-form-urlencoded");
            httppost.setHeader("Authorization", "Basic " +
                    new String(Base64.getEncoder().encode((this.clientID + ":" + this.clientSecret)
                            .getBytes(StandardCharsets.UTF_8))));

            HttpResponse response = httpClient.execute(httppost);

            HttpEntity entity = response.getEntity();

            if (response.getStatusLine().getStatusCode() == 200) { // ok request
                if (entity != null) {
                    // reading the body
                    try (InputStream instream = entity.getContent()) {
                        Scanner scanner = new Scanner(instream).useDelimiter("\\A");
                        String result = scanner.hasNext() ? scanner.next() : "";
                        JSONObject jsonobject = new JSONObject(result);
                        String token = jsonobject.get("access_token").toString();
                        return new SpotifyClientImp(token);
                    }
                }
            }

        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();

        }
        return null;
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

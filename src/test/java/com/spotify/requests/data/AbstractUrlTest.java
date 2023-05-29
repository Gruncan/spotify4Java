package com.spotify.requests.data;

import com.json.JSONObject;
import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.urls.SpotifyClientMock;

public class AbstractUrlTest {

    private static final String LOCATION = "src/test/java/com/spotify/requests/data/resources/";
    private static final String VERSION = "V1_0_0";

    private static JSONObject json;

    static {
        String filename = String.format("SpotifyResponses-%s.json", VERSION);
        json = new JSONObject(Util.getFileContents(LOCATION + filename));
    }

    protected SpotifyClientMock client;

    public AbstractUrlTest() {
        this.client = new SpotifyClientMock();
    }

    public String getCorrectURL(Class<? extends SpotifyRequestVariant> cls) {
        JSONObject ret = json.getJSONObject(cls.toString());
        return ret.getString("url");
    }


}

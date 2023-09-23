package dev.gruncan.spotify.requests.data;

import dev.gruncan.json.JSONObject;
import dev.gruncan.spotify.api.web.requests.SpotifyRequestVariant;
import dev.gruncan.spotify.requests.urls.SpotifyClientMock;

public class AbstractUrlTest {

    private static final String LOCATION = "src/test/java/dev/gruncan/spotify/requests/data/resources/";
    private static final String VERSION = "V1_5_0";

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

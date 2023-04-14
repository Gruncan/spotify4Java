package com.spotify.requests.tracks;

import com.spotify.SpotifyClient;
import com.spotify.SpotifyClientBuilderTester;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TrackGetTest {


    @Test
    public void trackGetUrlBuildTest() {
        TrackGet trackGet = new TrackGet("id1");


        String url = trackGet.buildRequestUrl();

        assertEquals("tracks/id1", url);
    }

    @Test
    @Tag("SlowNetworkTest")
    public void trackGetExecuteTest() {
        String id = "2fOYcnUo9iPTOqIlSg26MY";
        TrackGet trackGet = new TrackGet(id);
        SpotifyClient scbt = new SpotifyClientBuilderTester().getBuiltClient();
//        RequestResponse response = scbt.executeRequest(trackGet);

//        assertEquals(200, response.getCode());
    }

}
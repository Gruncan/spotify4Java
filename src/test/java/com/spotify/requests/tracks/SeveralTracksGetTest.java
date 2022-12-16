package com.spotify.requests.tracks;

import com.spotify.SpotifyClient;
import com.spotify.SpotifyClientBuilderTester;
import com.spotify.requests.util.Market;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SeveralTracksGetTest {


    @Test
    public void severalTrackGetUrlBuildTest() {

        SeveralTracksGet tracksGet = new SeveralTracksGet("id1", "id2", "id3");
        tracksGet.setMarket(Market.GB);

        String url = tracksGet.buildRequestUrl();


        assertEquals("tracks?ids=id1,id2,id3&market=GB", url);


    }


    @Test
    public void severalTrackGetExecuteTest() {
        String[] songs = new String[]{"1ljziaoMnRH95aPeOSGAtr", "2fOYcnUo9iPTOqIlSg26MY"}
        SeveralTracksGet tracksGet = new SeveralTracksGet(songs);

        SpotifyClient scbt = new SpotifyClientBuilderTester().getBuiltClient();

        scbt.executeRequest(tracksGet);


    }


}
package com.spotify.objects.track;

import com.spotify.json.JSONObject;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.tracks.TrackGet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class TrackArtistTest {


    @Test
    public void serialize() {
        String testData = """
                {

                                
                    "test": true

                }""";
        JSONObject jsonObject = new JSONObject(testData);
        AbstractRequest<TrackArtist> trackGet = new TrackGet("testId");

        assertNotNull(jsonObject);
        TrackArtist trackArtist = trackGet.serialize(jsonObject);
        System.out.println(trackArtist);

        assertNotNull(trackArtist);
    }

}
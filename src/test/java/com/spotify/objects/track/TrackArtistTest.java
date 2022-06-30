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

                    "external_urls":{
                        "spotify":"https://open.spotify.com/artist/1iNqsUDUraNWrj00bqssQG"
                    },
                    "href":"https://api.spotify.com/v1/artists/1iNqsUDUraNWrj00bqssQG",
                    "id":"1iNqsUDUraNWrj00bqssQG",
                    "name":"Dreamville",
                    "type":"artist",
                    "uri":"spotify:artist:1iNqsUDUraNWrj00bqssQG"

                }""";
        JSONObject jsonObject = new JSONObject(testData);
        AbstractRequest<TrackArtist> trackGet = new TrackGet("testId");

        assertNotNull(jsonObject);
        TrackArtist trackArtist = trackGet.serialize(jsonObject);
        System.out.println(trackArtist.toString());

        assertNotNull(trackArtist);
    }

}
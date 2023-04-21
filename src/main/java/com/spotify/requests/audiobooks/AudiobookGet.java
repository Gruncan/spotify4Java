package com.spotify.requests.audiobooks;

import com.spotify.objects.SpotifySerialize;
import com.spotify.objects.audiobooks.Audiobook;
import com.spotify.objects.wrappers.Country;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;
import com.spotify.requests.SpotifySubRequest;
import lombok.Setter;

@Setter
@SpotifyRequest("audiobooks")
@SpotifySerialize(Audiobook.class)
public class AudiobookGet extends AbstractRequest {


    @SpotifySubRequest
    private final String id;

    @SpotifyRequestField
    private Country market;

    public AudiobookGet(String id) {
        this.id = id;
    }

}

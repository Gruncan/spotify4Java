package com.spotify.requests.audiobooks;

import com.spotify.objects.SpotifySerialize;
import com.spotify.objects.audiobooks.AudiobookChapter;
import com.spotify.objects.audiobooks.SimplifiedChapter;
import com.spotify.objects.wrappers.Country;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;
import com.spotify.requests.SpotifySubRequest;

@SpotifyRequest(value = "audiobooks", end = "chapters")
@SpotifySerialize(AudiobookChapter.class)
public class AudiobookChaptersGet extends AbstractRequest {


    @SpotifySubRequest
    private final String id;

    @SpotifyRequestField
    private Country market;

    @SpotifyRequestField
    private int limit;

    @SpotifyRequestField
    private int offset;


    public AudiobookChaptersGet(String id) {
        this.id = id;
    }
}

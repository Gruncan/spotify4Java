package com.spotify.requests.playlists;

import com.spotify.requests.AbstractRequest;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;

@SpotifyRequest("browse/featured-playlist")
public class FeaturedPlaylistGet extends AbstractRequest {

    @SpotifyRequestField
    private String country;

    @SpotifyRequestField
    private String locale;

    @SpotifyRequestField
    private String timestamp;

    @SpotifyRequestField
    private int limit;

    @SpotifyRequestField
    private int offset;

}

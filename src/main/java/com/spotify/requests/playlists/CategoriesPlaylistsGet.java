package com.spotify.requests.playlists;

import com.spotify.objects.wrappers.Market;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;
import com.spotify.requests.SpotifySubRequest;
import lombok.Setter;

@Setter
@SpotifyRequest(value = "browse/categories", end = "playlist")
public class CategoriesPlaylistsGet extends AbstractRequest {

    @SpotifySubRequest
    private final String id;

    @SpotifyRequestField
    private Market country;

    @SpotifyRequestField
    private int limit;

    @SpotifyRequestField
    private int offset;

    public CategoriesPlaylistsGet(String id) {
        this.id = id;
    }

}
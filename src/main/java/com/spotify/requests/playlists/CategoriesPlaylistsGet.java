package com.spotify.requests.playlists;

import com.spotify.objects.wrappers.Market;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;
import com.spotify.requests.SpotifySubRequest;

@SpotifyRequest(value = "browse/categories", end = "playlist")
public class CategoriesPlaylistsGet extends AbstractRequest {

    @SpotifySubRequest
    private final String category_id;

    @SpotifyRequestField
    private Market country;

    @SpotifyRequestField
    private int limit;

    @SpotifyRequestField
    private int offset;

    public CategoriesPlaylistsGet(String id) {
        this.category_id = id;
    }

}

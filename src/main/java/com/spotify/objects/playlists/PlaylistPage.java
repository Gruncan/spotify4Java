package com.spotify.objects.playlists;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import com.spotify.objects.search.AbstractSearchItems;
import lombok.Getter;

@Getter
public class PlaylistPage extends AbstractSearchItems implements SpotifyObject {

    @SpotifyField
    private SimplifiedPlaylist[] items;
}

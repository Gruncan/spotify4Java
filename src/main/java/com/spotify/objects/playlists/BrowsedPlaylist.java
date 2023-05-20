package com.spotify.objects.playlists;

import com.spotify.objects.SpotifyField;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BrowsedPlaylist extends PlaylistTracksSearch {

    @SpotifyField
    private String message;


}

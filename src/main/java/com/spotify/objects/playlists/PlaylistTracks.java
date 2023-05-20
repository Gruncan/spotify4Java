package com.spotify.objects.playlists;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.search.AbstractSearchItems;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlaylistTracks extends AbstractSearchItems {

    @SpotifyField
    private PlaylistTrack items;

}

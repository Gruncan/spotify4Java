package dev.gruncan.spotify.objects.playlists;

import dev.gruncan.spotify.objects.SpotifyField;
import dev.gruncan.spotify.objects.SpotifyObject;
import dev.gruncan.spotify.objects.search.AbstractSearchItems;
import lombok.Getter;

@Getter
public class PlaylistPage extends AbstractSearchItems implements SpotifyObject {

    @SpotifyField
    private SimplifiedPlaylist[] items;
}

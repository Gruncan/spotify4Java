package dev.gruncan.spotify.webapi.objects.playlists;

import dev.gruncan.spotify.webapi.objects.SpotifyField;
import dev.gruncan.spotify.webapi.objects.SpotifyObject;
import dev.gruncan.spotify.webapi.objects.search.AbstractSearchItems;
import dev.gruncan.spotify.webapi.requests.me.playlists.MyPlaylistsGet;
import lombok.Getter;

/**
 * Represents a playlist page
 *
 * @see MyPlaylistsGet
 * @see SimplifiedPlaylist
 * @see AbstractSearchItems
 * @see SpotifyObject
 */
@Getter
public class PlaylistPage extends AbstractSearchItems implements SpotifyObject {

    /**
     * An array of SimplifiedPlaylists
     */
    @SpotifyField
    private SimplifiedPlaylist[] items;
}

package dev.gruncan.spotify.webapi.objects.playlists;

import dev.gruncan.spotify.webapi.objects.SpotifyField;
import dev.gruncan.spotify.webapi.objects.SpotifyObject;
import dev.gruncan.spotify.webapi.objects.search.items.SearchItemsPlaylists;
import dev.gruncan.spotify.webapi.objects.wrappers.SpotifyFollowers;
import dev.gruncan.spotify.webapi.requests.playlists.PlaylistGet;
import dev.gruncan.spotify.webapi.requests.users.UserPlaylistCreatePost;
import lombok.Getter;


/**
 * Represents a spotify episode<br>
 * Serialized from <a href="https://developer.spotify.com/documentation/web-api/reference/get-playlist">PlaylistGet</a>
 *
 * @see PlaylistGet
 * @see UserPlaylistCreatePost
 * @see SearchItemsPlaylists
 * @see SimplifiedPlaylist
 * @see SpotifyFollowers
 * @see SpotifyObject
 */
@Getter
public class Playlist extends SimplifiedPlaylist implements SpotifyObject {


    /**
     * Information about the followers of the playlist.
     */
    @SpotifyField
    private SpotifyFollowers followers;


}

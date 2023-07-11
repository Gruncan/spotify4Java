package dev.gruncan.spotify.objects.playlists;

import dev.gruncan.spotify.objects.SpotifyField;
import dev.gruncan.spotify.objects.SpotifyObject;
import dev.gruncan.spotify.objects.search.items.SearchItemsPlaylists;
import dev.gruncan.spotify.objects.wrappers.SpotifyFollowers;
import dev.gruncan.spotify.requests.playlists.PlaylistGet;
import dev.gruncan.spotify.requests.users.UserPlaylistCreatePost;
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

package com.spotify.objects.playlists;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import com.spotify.objects.search.items.SearchItemsPlaylists;
import com.spotify.objects.wrappers.SpotifyFollowers;
import com.spotify.requests.playlists.PlaylistGet;
import lombok.Getter;


/**
 * Represents a spotify episode<br>
 * Serialized from <a href="https://developer.spotify.com/documentation/web-api/reference/get-playlist">PlaylistGet</a>
 *
 * @see PlaylistGet
 * @see SearchItemsPlaylists
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

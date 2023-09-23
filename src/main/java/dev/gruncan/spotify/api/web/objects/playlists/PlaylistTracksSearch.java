package dev.gruncan.spotify.api.web.objects.playlists;

import dev.gruncan.spotify.api.web.objects.SpotifyField;
import dev.gruncan.spotify.api.web.objects.SpotifyObject;
import dev.gruncan.spotify.api.web.objects.search.AbstractSearchItems;
import dev.gruncan.spotify.api.web.requests.playlists.PlaylistTracksGet;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents the tracks of a playlist
 * Serialized from <a href="https://developer.spotify.com/documentation/web-api/reference/get-playlists-tracks">PlaylistTracksGet</a>
 *
 * @see PlaylistTracksGet
 * @see AbstractSearchItems
 * @see BrowsedPlaylist
 * @see PlaylistTrack
 * @see SpotifyObject
 */
@Getter
@Setter
public class PlaylistTracksSearch extends AbstractSearchItems implements SpotifyObject {

    /**
     * An array of {@link PlaylistTrack} for an artists
     */
    @SpotifyField
    private PlaylistTrack[] items;

}

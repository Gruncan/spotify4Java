package dev.gruncan.spotify.objects.playlists;

import dev.gruncan.spotify.objects.SpotifyField;
import dev.gruncan.spotify.objects.SpotifyObject;
import dev.gruncan.spotify.objects.search.AbstractSearchItems;
import dev.gruncan.spotify.requests.playlists.PlaylistCategoriesGet;
import dev.gruncan.spotify.requests.playlists.PlaylistFeaturedGet;
import lombok.Getter;
import lombok.Setter;

/**
 * A spotify playlist from the browse tab
 * Serialized from <a href="https://developer.spotify.com/documentation/web-api/reference/get-featured-playlists">FeaturedPlaylistGet</a>,
 * <a href="https://developer.spotify.com/documentation/web-api/reference/get-a-categories-playlists">CategoriesPlaylistsGet</a>
 *
 * @see PlaylistFeaturedGet
 * @see PlaylistCategoriesGet
 * @see PlaylistTracksSearch
 * @see PlaylistTrack
 * @see AbstractSearchItems
 * @see SpotifyObject
 */
@Getter
@Setter
public class BrowsedPlaylist extends PlaylistTracksSearch implements SpotifyObject {

    /**
     * The message of the playlist page set
     */
    @SpotifyField
    private String message;


}

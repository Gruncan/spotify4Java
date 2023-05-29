package com.spotify.objects.playlists;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import com.spotify.objects.search.AbstractSearchItems;
import com.spotify.requests.playlists.CategoriesPlaylistsGet;
import com.spotify.requests.playlists.FeaturedPlaylistGet;
import lombok.Getter;
import lombok.Setter;

/**
 * A spotify playlist from the browse tab
 * Serialized from <a href="https://developer.spotify.com/documentation/web-api/reference/get-featured-playlists">FeaturedPlaylistGet</a>,
 * <a href="https://developer.spotify.com/documentation/web-api/reference/get-a-categories-playlists">CategoriesPlaylistsGet</a>
 *
 * @see FeaturedPlaylistGet
 * @see CategoriesPlaylistsGet
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

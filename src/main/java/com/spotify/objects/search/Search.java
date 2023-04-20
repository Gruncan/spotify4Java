package com.spotify.objects.search;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import com.spotify.objects.SpotifyOptional;
import com.spotify.objects.search.items.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@SpotifyOptional
public class Search implements SpotifyObject {

    @SpotifyField
    private SearchItemTracks tracks;

    @SpotifyField
    private SearchItemArtists artists;

    @SpotifyField
    private SearchItemsAlbums albums;

    @SpotifyField
    private SearchItemsPlaylists playlists;

    @SpotifyField
    private SearchItemsShows shows;

    @SpotifyField
    private SearchItemsEpisodes episodes;

    @SpotifyField
    private SearchItemsAudiobooks audiobooks;

}

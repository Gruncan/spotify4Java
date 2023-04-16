package com.spotify.objects.search;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import com.spotify.objects.SpotifyOptional;
import com.spotify.objects.albums.Album;
import com.spotify.objects.artists.Artist;
import com.spotify.objects.audiobooks.Audiobook;
import com.spotify.objects.episodes.Episode;
import com.spotify.objects.playlists.Playlist;
import com.spotify.objects.shows.Show;
import com.spotify.objects.tracks.Track;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@SpotifyOptional
public class Search implements SpotifyObject {

    @SpotifyField
    private SearchItems<Track> tracks;

    @SpotifyField
    private SearchItems<Artist> artists;

    @SpotifyField
    private SearchItems<Album> albums;

    @SpotifyField
    private SearchItems<Playlist> playlists;

    @SpotifyField
    private SearchItems<Show> shows;

    @SpotifyField
    private SearchItems<Episode> episodes;

    @SpotifyField
    private SearchItems<Audiobook> audiobooks;

}

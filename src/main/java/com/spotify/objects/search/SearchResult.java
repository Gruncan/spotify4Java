package com.spotify.objects.search;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.track.Track;
import com.spotify.objects.track.TrackArtist;

import java.io.Serializable;


public class SearchResult implements Serializable {


    @SpotifyField(value = "artists")
    public final TrackArtist[] artists;
    @SpotifyField(value = "tracks")
    private final Track[] tracks;


    public SearchResult(TrackArtist[] artists, Track[] tracks) {
        this.artists = artists;
        this.tracks = tracks;
    }


    public TrackArtist[] getArtists() {
        return artists;
    }


    public Track[] getTracks() {
        return tracks;
    }
}

package com.spotify.objects.search;

import com.spotify.objects.ISerializable;
import com.spotify.objects.track.Track;
import com.spotify.objects.track.TrackArtist;

public class SearchResult implements ISerializable {


    public final TrackArtist[] artists;
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

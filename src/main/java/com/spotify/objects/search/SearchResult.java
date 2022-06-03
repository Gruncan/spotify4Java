package com.spotify.objects.search;

import com.spotify.objects.ISerializable;
import com.spotify.objects.track.TrackArtist;

public class SearchResult implements ISerializable {


    public final TrackArtist[] artists;


    public SearchResult(TrackArtist[] artists) {
        this.artists = artists;
    }


    public TrackArtist[] getArtists() {
        return artists;
    }
}

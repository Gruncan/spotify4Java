package com.spotify.objects.tracks;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import com.spotify.objects.SpotifyOptional;
import com.spotify.objects.albums.Album;
import com.spotify.objects.artists.Artist;
import com.spotify.objects.wrappers.Country;
import com.spotify.objects.wrappers.SpotifyExternalID;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Track extends SimplifiedTrack {


    @SpotifyField
    private Artist[] artists;

    @SpotifyOptional
    @SpotifyField
    private Album album;

    @SpotifyOptional
    @SpotifyField("external_ids")
    private SpotifyExternalID externalIDs;

    @SpotifyOptional
    @SpotifyField
    private int popularity;


}
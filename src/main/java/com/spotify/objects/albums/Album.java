package com.spotify.objects.albums;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import com.spotify.objects.SpotifyOptional;
import com.spotify.objects.artists.Artist;
import com.spotify.objects.artists.SimplifiedArtist;
import com.spotify.objects.tracks.Track;
import com.spotify.objects.wrappers.Country;
import com.spotify.objects.wrappers.SpotifyCopyright;
import com.spotify.objects.wrappers.SpotifyExternalID;
import com.spotify.objects.wrappers.SpotifyImage;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

@Getter
@Setter
public class Album extends SimplifiedAlbum {


    @SpotifyField
    @SpotifyOptional
    private Artist[] artists;

    @SpotifyField
    @SpotifyOptional
    private Track[] tracks;




}
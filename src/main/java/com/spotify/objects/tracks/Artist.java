package com.spotify.objects.tracks;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import com.spotify.objects.SpotifyOptional;
import com.spotify.objects.wrappers.SpotifyImage;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

@Getter
@Setter
public class Artist extends SimplifiedArtist implements SpotifyObject {


    @SpotifyOptional
    @SpotifyField(value = "total", path = {"followers"})
    private int followers;

    @SpotifyOptional
    @SpotifyField
    private String[] genres;

    @SpotifyOptional
    @SpotifyField
    private SpotifyImage[] images;

    @SpotifyOptional
    @SpotifyField
    private int popularity;

    @Override
    public String toString() {
        return "Artist{" +
                "followers=" + followers +
                ", genres=" + Arrays.toString(genres) +
                ", images=" + Arrays.toString(images) +
                ", popularity=" + popularity +
                '}';
    }
}

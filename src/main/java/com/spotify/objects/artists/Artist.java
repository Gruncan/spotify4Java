package com.spotify.objects.artists;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyOptional;
import com.spotify.objects.wrappers.SpotifyImage;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

@Getter
@Setter
@SpotifyOptional
public class Artist extends SimplifiedArtist {


    @SpotifyField(value = "total", path = {"followers"})
    private int followers;

    @SpotifyField
    private String[] genres;

    @SpotifyField
    private SpotifyImage[] images;

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

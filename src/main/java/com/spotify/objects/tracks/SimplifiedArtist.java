package com.spotify.objects.tracks;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import com.spotify.objects.SpotifyOptional;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SimplifiedArtist implements SpotifyObject {


    @SpotifyOptional
    @SpotifyField(value = "spotify", path = {"external_urls"})
    protected String externalUrlsSpotify;

    @SpotifyField
    protected String href;

    @SpotifyField
    protected String id;

    @SpotifyField
    protected String name;

    @SpotifyField
    protected String type;

    @SpotifyField
    protected String uri;

    @Override
    public String toString() {
        return "SimplifiedArtist{" +
                "externalUrlsSpotify=" + externalUrlsSpotify +
                ", href='" + href + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", uri='" + uri + '\'' +
                '}';
    }
}

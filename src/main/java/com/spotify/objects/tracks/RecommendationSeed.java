package com.spotify.objects.tracks;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import com.spotify.objects.SpotifyOptional;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@SpotifyOptional
public class RecommendationSeed implements SpotifyObject {

    @SpotifyField
    private int afterFilteringSize;

    @SpotifyField
    private int afterRelinkingSize;

    @SpotifyField
    private String href;

    @SpotifyField
    private String id;

    @SpotifyField
    private int initialPoolSize;

    @SpotifyField
    private String type;

}

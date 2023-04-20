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
public class TrackRecommendation implements SpotifyObject {


    @SpotifyField
    private RecommendationSeed[] recommendationSeeds;

    @SpotifyField
    @SpotifyOptional
    private Track[] tracks;


}

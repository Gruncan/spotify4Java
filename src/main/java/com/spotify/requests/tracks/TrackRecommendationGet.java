package com.spotify.requests.tracks;

import com.spotify.json.JsonObject;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.RequestQuery;
import com.spotify.requests.util.Market;
import com.spotify.requests.util.ParameterPairBuilder;
import com.spotify.util.Util;


/**
 * Recommendations are generated based on the available information for a given seed entity and matched against similar artists and tracks.
 * If there is sufficient information about the provided seeds, a list of tracks will be returned together with pool size details.
 * For artists and tracks that are very new or obscure there might not be enough data to generate a list of tracks.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/#/operations/get-recommendations">Spotify Docs</a>
 */
public class TrackRecommendationGet extends AbstractRequest {

    private final static String URL = "recommendations/";

    /**
     * @param token       The token of the related spotify api session
     * @param seedArtists The array of seed artists (up to 5) to generate a recommendation
     * @param seedGenres  The array of seed genres (up to 5) to generate a recommendation
     * @param seedTracks  The array of seed tracks (up to 5) to generate a recommendation
     */
    public TrackRecommendationGet(String token, String[] seedArtists, String[] seedGenres, String[] seedTracks) {

        super(token, new ParameterPairBuilder().addKeys("seed_artists", "seed_genres", "seed_tracks", "limit", "market",
                        "max_acousticness", "max_danceability", "max_duration_ms", "max_energy", "max_instrumentalness",
                        "max_key", "max_liveness", "max_loudness", "max_mode", "max_popularity", "max_speechiness",
                        "max_tempo", "max_time_signature", "max_valence", "min_acousticness", "min_danceability",
                        "min_duration_ms", "min_energy", "min_instrumentalness", "min_key", "min_liveness",
                        "min_loudness", "min_mode", "min_popularity", "min_speechiness", "min_tempo",
                        "min_time_signature", "min_valence", "target_acousticness", "target_danceability",
                        "target_duration_ms", "target_energy", "target_instrumentalness", "target_key", "target_liveness",
                        "target_loudness", "target_mode", "target_popularity", "target_speechiness", "target_tempo",
                        "target_time_signature", "target_valence")
                .addClasses(String.class, String.class, String.class, int.class, Market.class, float.class, float.class,
                        int.class, float.class, float.class, int.class, float.class, float.class, int.class, int.class,
                        float.class, float.class, int.class, float.class, float.class, float.class, int.class, float.class,
                        float.class, int.class, float.class, float.class, int.class, int.class, float.class, float.class,
                        int.class, float.class, float.class, float.class, int.class, float.class, float.class, int.class,
                        float.class, float.class, int.class, int.class, float.class, float.class, int.class, float.class)
                .build());
        super.addQuery(new RequestQuery<>("seed_artists", Util.join(seedArtists, ",")));
        super.addQuery(new RequestQuery<>("seed_genres", Util.join(seedGenres, ",")));
        super.addQuery(new RequestQuery<>("seed_tracks", Util.join(seedTracks, ",")));
    }

    @Override
    public JsonObject execute() {
        return super.requestGet(URL);
    }
}

package com.spotify.requests.tracks;

import com.spotify.SpotifyResponse;
import com.spotify.objects.SpotifySerialize;
import com.spotify.objects.tracks.TrackRecommendation;
import com.spotify.objects.wrappers.Country;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;
import com.spotify.requests.SpotifyRequestVariant;
import lombok.Setter;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;


/**
 * Recommendations are generated based on the available information for a given seed entity and matched against similar
 * artists and tracks. If there is sufficient information about the provided seeds, a list of tracks will be returned
 * together with pool size details.<br>
 * For artists and tracks that are very new or obscure there might not be enough data to generate a list of tracks.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/get-recommendations">Spotify Docs</a>
 * <p>Serializes into {@link TrackRecommendation}</p>
 *
 * @see TrackRecommendation
 * @see SpotifyRequestVariant
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@Setter
@SpotifyRequest("recommendations")
@SpotifySerialize(TrackRecommendation.class)
public class TrackRecommendationGet implements SpotifyRequestVariant {


    /**
     * A list of Spotify IDs for seed artists. Up to 5 seed values may be provided in any combination of seed_artists,
     * seed_tracks and seed_genres.
     */
    @SpotifyRequestField("seed_artists")
    private final String[] seedArtists;

    /**
     * A list of any genres in the set of available genre seeds. Up to 5 seed values may be provided in any combination
     * of seed_artists, seed_tracks and seed_genres.
     */
    @SpotifyRequestField("seed_genres")
    private final String[] seedGenres;

    /**
     * A comma separated list of Spotify IDs for a seed track. Up to 5 seed values may be provided in any combination of
     * seed_artists, seed_tracks and seed_genres.
     */
    @SpotifyRequestField("seed_tracks")
    private final String[] seedTracks;

    /**
     * The target size of the list of recommended tracks. For seeds with unusually small pools or when highly restrictive
     * filtering is applied, it may be impossible to generate the requested number of recommended tracks. Debugging
     * information for such cases is available in the response. Default: 20. Minimum: 1. Maximum: 100.
     */
    @SpotifyRequestField
    private int limit;

    /**
     * An ISO 3166-1 alpha-2 country code. If a country code is specified, only content that is available in that market
     * will be returned.
     */
    @SpotifyRequestField
    private Country market;


    /**
     * For each tunable track attribute, a hard floor on the selected track attribute’s value can be provided.
     * See tunable track attributes below for the list of available options. For example, min_tempo=140 would restrict
     * results to only those tracks with a tempo of greater than 140 beats per minute.
     */
    @SpotifyRequestField("min_acousticness")
    private double minAcousticness;
    /**
     * For each tunable track attribute, a hard ceiling on the selected track attribute’s value can be provided.
     * See tunable track attributes below for the list of available options. For example, max_instrumentalness=0.35
     * would filter out most tracks that are likely to be instrumental.
     */
    @SpotifyRequestField("max_acousticness")
    private double maxAcousticness;
    /**
     * For each of the tunable track attributes (below) a target value may be provided. Tracks with the attribute values
     * nearest to the target values will be preferred. For example, you might request target_energy=0.6 and
     * target_danceability=0.8. All target values will be weighed equally in ranking results.
     */
    @SpotifyRequestField("target_acousticness")
    private double targetAcousticness;

    /**
     * For each tunable track attribute, a hard floor on the selected track attribute’s value can be provided.
     * See tunable track attributes below for the list of available options. For example, min_tempo=140 would restrict
     * results to only those tracks with a tempo of greater than 140 beats per minute.
     */
    @SpotifyRequestField("min_danceability")
    private double minDanceability;
    /**
     * For each tunable track attribute, a hard ceiling on the selected track attribute’s value can be provided.
     * See tunable track attributes below for the list of available options. For example, max_instrumentalness=0.35
     * would filter out most tracks that are likely to be instrumental.
     */

    @SpotifyRequestField("max_danceability")
    private double maxDanceability;
    /**
     * For each of the tunable track attributes (below) a target value may be provided. Tracks with the attribute values
     * nearest to the target values will be preferred. For example, you might request target_energy=0.6 and
     * target_danceability=0.8. All target values will be weighed equally in ranking results.
     */
    @SpotifyRequestField("target_danceability")
    private double targetDanceability;

    /**
     * For each tunable track attribute, a hard floor on the selected track attribute’s value can be provided.
     * See tunable track attributes below for the list of available options. For example, min_tempo=140 would restrict
     * results to only those tracks with a tempo of greater than 140 beats per minute.
     */
    @SpotifyRequestField("min_energy")
    private double minEnergy;
    /**
     * For each tunable track attribute, a hard ceiling on the selected track attribute’s value can be provided.
     * See tunable track attributes below for the list of available options. For example, max_instrumentalness=0.35
     * would filter out most tracks that are likely to be instrumental.
     */
    @SpotifyRequestField("max_energy")
    private double maxEnergy;
    /**
     * For each of the tunable track attributes (below) a target value may be provided. Tracks with the attribute values
     * nearest to the target values will be preferred. For example, you might request target_energy=0.6 and
     * target_danceability=0.8. All target values will be weighed equally in ranking results.
     */
    @SpotifyRequestField("target_energy")
    private double targetEnergy;

    /**
     * For each tunable track attribute, a hard floor on the selected track attribute’s value can be provided.
     * See tunable track attributes below for the list of available options. For example, min_tempo=140 would restrict
     * results to only those tracks with a tempo of greater than 140 beats per minute.
     */
    @SpotifyRequestField("min_instrumentalness")
    private double minInstrumentalness;
    /**
     * For each tunable track attribute, a hard ceiling on the selected track attribute’s value can be provided.
     * See tunable track attributes below for the list of available options. For example, max_instrumentalness=0.35
     * would filter out most tracks that are likely to be instrumental.
     */
    @SpotifyRequestField("max_instrumentalness")
    private double maxInstrumentalness;
    /**
     * For each of the tunable track attributes (below) a target value may be provided. Tracks with the attribute
     * values nearest to the target values will be preferred. For example, you might request target_energy=0.6 and
     * target_danceability=0.8. All target values will be weighed equally in ranking results.
     */
    @SpotifyRequestField("target_instrumentalness")
    private double targetInstrumentalness;

    /**
     * For each tunable track attribute, a hard floor on the selected track attribute’s value can be provided.
     * See tunable track attributes below for the list of available options. For example, min_tempo=140 would restrict
     * results to only those tracks with a tempo of greater than 140 beats per minute.
     */
    @SpotifyRequestField("min_liveness")
    private double minLiveness;

    /**
     * For each tunable track attribute, a hard ceiling on the selected track attribute’s value can be provided.
     * See tunable track attributes below for the list of available options. For example, max_instrumentalness=0.35
     * would filter out most tracks that are likely to be instrumental.
     */
    @SpotifyRequestField("max_liveness")
    private double maxLiveness;

    /**
     * For each of the tunable track attributes (below) a target value may be provided. Tracks with the attribute values
     * nearest to the target values will be preferred. For example, you might request target_energy=0.6 and
     * target_danceability=0.8. All target values will be weighed equally in ranking results.
     */
    @SpotifyRequestField("target_liveness")
    private double targetLiveness;


    /**
     * For each tunable track attribute, a hard floor on the selected track attribute’s value can be provided.
     * See tunable track attributes below for the list of available options. For example, min_tempo=140 would restrict
     * results to only those tracks with a tempo of greater than 140 beats per minute.
     */
    @SpotifyRequestField("min_loudness")
    private double minLoudness;

    /**
     * For each tunable track attribute, a hard ceiling on the selected track attribute’s value can be provided.
     * See tunable track attributes below for the list of available options. For example, max_instrumentalness=0.35
     * would filter out most tracks that are likely to be instrumental.
     */
    @SpotifyRequestField("max_loudness")
    private double maxLoudness;

    /**
     * For each of the tunable track attributes (below) a target value may be provided. Tracks with the attribute
     * values nearest to the target values will be preferred. For example, you might request target_energy=0.6 and
     * target_danceability=0.8. All target values will be weighed equally in ranking results.
     */
    @SpotifyRequestField("target_loudness")
    private double targetLoudness;


    /**
     * For each tunable track attribute, a hard floor on the selected track attribute’s value can be provided.
     * See tunable track attributes below for the list of available options. For example, min_tempo=140 would restrict
     * results to only those tracks with a tempo of greater than 140 beats per minute.
     */
    @SpotifyRequestField("min_speechiness")
    private double minSpeechiness;

    /**
     * For each tunable track attribute, a hard ceiling on the selected track attribute’s value can be provided.
     * See tunable track attributes below for the list of available options. For example, max_instrumentalness=0.35
     * would filter out most tracks that are likely to be instrumental.
     */
    @SpotifyRequestField("max_speechiness")
    private double maxSpeechiness;

    /**
     * For each of the tunable track attributes (below) a target value may be provided. Tracks with the attribute
     * values nearest to the target values will be preferred. For example, you might request target_energy=0.6 and
     * target_danceability=0.8. All target values will be weighed equally in ranking results.
     */
    @SpotifyRequestField("target_speechiness")
    private double targetSpeechiness;


    /**
     * For each tunable track attribute, a hard floor on the selected track attribute’s value can be provided.
     * See tunable track attributes below for the list of available options. For example, min_tempo=140 would restrict
     * results to only those tracks with a tempo of greater than 140 beats per minute.
     */
    @SpotifyRequestField("max_tempo")
    private double minTempo;

    /**
     * For each tunable track attribute, a hard ceiling on the selected track attribute’s value can be provided.
     * See tunable track attributes below for the list of available options. For example, max_instrumentalness=0.35
     * would filter out most tracks that are likely to be instrumental.
     */
    @SpotifyRequestField("max_tempo")
    private double maxTempo;

    /**
     * Target tempo (BPM)
     */
    @SpotifyRequestField("target_tempo")
    private double targetTempo;


    /**
     * For each tunable track attribute, a hard floor on the selected track attribute’s value can be provided.
     * See tunable track attributes below for the list of available options. For example, min_tempo=140 would
     * restrict results to only those tracks with a tempo of greater than 140 beats per minute.
     */
    @SpotifyRequestField("min_valence")
    private double minValence;

    /**
     * For each tunable track attribute, a hard ceiling on the selected track attribute’s value can be provided.
     * See tunable track attributes below for the list of available options. For example, max_instrumentalness=0.35
     * would filter out most tracks that are likely to be instrumental.
     */
    @SpotifyRequestField("max_valence")
    private double maxValence;

    /**
     * For each of the tunable track attributes (below) a target value may be provided. Tracks with the attribute values
     * nearest to the target values will be preferred. For example, you might request target_energy=0.6 and
     * target_danceability=0.8. All target values will be weighed equally in ranking results.
     */
    @SpotifyRequestField("target_valence")
    private double targetValence;


    /**
     * For each tunable track attribute, a hard floor on the selected track attribute’s value can be provided.
     * See tunable track attributes below for the list of available options. For example, min_tempo=140 would restrict
     * results to only those tracks with a tempo of greater than 140 beats per minute.
     */
    @SpotifyRequestField("min_duration_ms")
    private int minDuration;
    /**
     * For each tunable track attribute, a hard ceiling on the selected track attribute’s value can be provided.
     * See tunable track attributes below for the list of available options. For example, max_instrumentalness=0.35
     * would filter out most tracks that are likely to be instrumental.
     */

    @SpotifyRequestField("max_duration_ms")
    private int maxDuration;

    /**
     * Target duration of the track (ms)
     */
    @SpotifyRequestField("target_duration_ms")
    private int targetDuration;

    /**
     * For each tunable track attribute, a hard floor on the selected track attribute’s value can be provided.
     * See tunable track attributes below for the list of available options. For example, min_tempo=140 would
     * restrict results to only those tracks with a tempo of greater than 140 beats per minute.
     */
    @SpotifyRequestField("min_key")
    private int minKey;

    /**
     * For each tunable track attribute, a hard ceiling on the selected track attribute’s value can be provided.
     * See tunable track attributes below for the list of available options. For example, max_instrumentalness=0.35
     * would filter out most tracks that are likely to be instrumental.
     */
    @SpotifyRequestField("max_key")
    private int maxKey;
    /**
     * For each of the tunable track attributes (below) a target value may be provided. Tracks with the attribute
     * values nearest to the target values will be preferred. For example, you might request target_energy=0.6 and
     * target_danceability=0.8. All target values will be weighed equally in ranking results.
     */
    @SpotifyRequestField("target_key")
    private int targetKey;


    /**
     * For each tunable track attribute, a hard floor on the selected track attribute’s value can be provided.
     * See tunable track attributes below for the list of available options. For example, min_tempo=140 would restrict
     * results to only those tracks with a tempo of greater than 140 beats per minute.
     */
    @SpotifyRequestField("min_mode")
    private int minMode;

    /**
     * For each tunable track attribute, a hard ceiling on the selected track attribute’s value can be provided.
     * See tunable track attributes below for the list of available options. For example, max_instrumentalness=0.35
     * would filter out most tracks that are likely to be instrumental.
     */
    @SpotifyRequestField("max_mode")
    private int maxMode;

    /**
     * For each of the tunable track attributes (below) a target value may be provided. Tracks with the attribute
     * values nearest to the target values will be preferred. For example, you might request target_energy=0.6 and
     * target_danceability=0.8. All target values will be weighed equally in ranking results.
     */
    @SpotifyRequestField("target_mode")
    private int targetMode;

    /**
     * For each tunable track attribute, a hard floor on the selected track attribute’s value can be provided.
     * See tunable track attributes below for the list of available options. For example, min_tempo=140 would restrict
     * results to only those tracks with a tempo of greater than 140 beats per minute.
     */
    @SpotifyRequestField("min_popularity")
    private int minPopularity;

    /**
     * For each tunable track attribute, a hard ceiling on the selected track attribute’s value can be provided.
     * See tunable track attributes below for the list of available options. For example, max_instrumentalness=0.35
     * would filter out most tracks that are likely to be instrumental.
     */
    @SpotifyRequestField("max_popularity")
    private int maxPopularity;

    /**
     * For each of the tunable track attributes (below) a target value may be provided.
     * Tracks with the attribute values nearest to the target values will be preferred. For example, you might request
     * target_energy=0.6 and target_danceability=0.8. All target values will be weighed equally in ranking results.
     */
    @SpotifyRequestField("target_popularity")
    private int targetPopularity;

    /**
     * For each tunable track attribute, a hard floor on the selected track attribute’s value can be provided.
     * See tunable track attributes below for the list of available options. For example, min_tempo=140 would restrict
     * results to only those tracks with a tempo of greater than 140 beats per minute.
     */
    @SpotifyRequestField("min_time_signature")
    private int minTimeSignature;

    /**
     * For each tunable track attribute, a hard ceiling on the selected track attribute’s value can be provided.
     * See tunable track attributes below for the list of available options. For example, max_instrumentalness=0.35 would
     * filter out most tracks that are likely to be instrumental.
     */
    @SpotifyRequestField("max_time_signature")
    private int maxTimeSignature;

    /**
     * For each of the tunable track attributes (below) a target value may be provided. Tracks with the attribute values
     * nearest to the target values will be preferred. For example, you might request target_energy=0.6 and target_danceability=0.8.
     * All target values will be weighed equally in ranking results.
     */
    @SpotifyRequestField("target_time_signature")
    private int targetTimeSignature;



    /**
     * Initializes the {@link TrackRecommendationGet} request
     * @param seedArtists The array of seed artists (up to 5) to generate a recommendation
     * @param seedGenres  The array of seed genres (up to 5) to generate a recommendation
     * @param seedTracks  The array of seed tracks (up to 5) to generate a recommendation
     */
    public TrackRecommendationGet(String[] seedArtists, String[] seedGenres, String[] seedTracks) {
        this.seedArtists = seedArtists;
        this.seedGenres = seedGenres;
        this.seedTracks = seedTracks;
    }


    /**
     * Sets all maximum's fields
     * @param maxs array of ordered fields <br>
     *
     *             {@link TrackRecommendationGet#maxAcousticness}, {@link TrackRecommendationGet#maxDanceability}, 
     *             {@link TrackRecommendationGet#maxEnergy}, {@link TrackRecommendationGet#maxInstrumentalness},
     *             {@link TrackRecommendationGet#maxLiveness}, {@link TrackRecommendationGet#maxLoudness}, 
     *             {@link TrackRecommendationGet#maxSpeechiness}, {@link TrackRecommendationGet#maxTempo},
     *             {@link TrackRecommendationGet#maxValence}, {@link TrackRecommendationGet#maxDuration},
     *             {@link TrackRecommendationGet#maxKey}, {@link TrackRecommendationGet#maxMode},
     *             {@link TrackRecommendationGet#maxPopularity}, {@link TrackRecommendationGet#maxTimeSignature}
     *
     *
     */
    public void setMaximums(double[] maxs) {
        if (maxs.length != 14)
            throw new IndexOutOfBoundsException(String.format("Failed to set maximums should be size 14 found size %s.", maxs.length));

        this.setGenericFields(maxs, "max_");
    }

    /**
     * Sets all minimum's of fields
     * @param mins array of ordered fields <br>
     *             {@link TrackRecommendationGet#minAcousticness}, {@link TrackRecommendationGet#minDanceability}, 
     *             {@link TrackRecommendationGet#minEnergy}, {@link TrackRecommendationGet#minInstrumentalness},
     *             {@link TrackRecommendationGet#minLiveness}, {@link TrackRecommendationGet#minLoudness}, 
     *             {@link TrackRecommendationGet#minSpeechiness}, {@link TrackRecommendationGet#minTempo},
     *             {@link TrackRecommendationGet#minValence}, {@link TrackRecommendationGet#minDuration},
     *             {@link TrackRecommendationGet#minKey}, {@link TrackRecommendationGet#minMode},
     *             {@link TrackRecommendationGet#minPopularity}, {@link TrackRecommendationGet#minTimeSignature}
     */
    public void setMinimums(double[] mins) {
        if (mins.length != 14)
            throw new IndexOutOfBoundsException(String.format("Failed to set minimums should be size 14 found size %s.", mins.length));

        this.setGenericFields(mins, "min_");
    }

    /**
     * Sets all targets's of fields
     * @param targets array of ordered fields <br>
     *             {@link TrackRecommendationGet#targetAcousticness}, {@link TrackRecommendationGet#targetDanceability}, 
     *             {@link TrackRecommendationGet#targetEnergy}, {@link TrackRecommendationGet#targetInstrumentalness},
     *             {@link TrackRecommendationGet#targetLiveness}, {@link TrackRecommendationGet#targetLoudness}, 
     *             {@link TrackRecommendationGet#targetSpeechiness}, {@link TrackRecommendationGet#targetTempo},
     *             {@link TrackRecommendationGet#targetValence}, {@link TrackRecommendationGet#targetDuration},
     *             {@link TrackRecommendationGet#targetKey}, {@link TrackRecommendationGet#targetMode},
     *             {@link TrackRecommendationGet#targetPopularity}, {@link TrackRecommendationGet#targetTimeSignature}
     */
    public void setTargets(double[] targets) {
        if (targets.length != 14)
            throw new IndexOutOfBoundsException(String.format("Failed to set targets should be size 14 found size %s", targets.length));

        this.setGenericFields(targets, "target_");
    }


    private void setGenericFields(double[] gen, String s) {
        List<Field> filteredFields = Arrays.stream(this.getClass().getDeclaredFields())
                .filter(field -> field.getName().startsWith(s)).toList();
        try {
            for (int i = 0; i < filteredFields.size(); i++) {
                Field f = filteredFields.get(i);
                f.setAccessible(true);
                if (f.getType().equals(int.class))
                    f.set(this, (int) gen[i]);
                else
                    f.set(this, gen[i]);

                f.setAccessible(false);
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }


}

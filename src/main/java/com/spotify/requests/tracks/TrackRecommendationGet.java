package com.spotify.requests.tracks;

import com.spotify.objects.SpotifySerialize;
import com.spotify.objects.tracks.TrackRecommendation;
import com.spotify.objects.wrappers.Country;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;
import lombok.Setter;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;


/**
 * Recommendations are generated based on the available information for a given seed entity and matched against similar artists and tracks.
 * If there is sufficient information about the provided seeds, a list of tracks will be returned together with pool size details.
 * For artists and tracks that are very new or obscure there might not be enough data to generate a list of tracks.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/#/operations/get-recommendations">Spotify Docs</a>
 */
@Setter
@SpotifyRequest("recommendations")
@SpotifySerialize(TrackRecommendation.class)
public class TrackRecommendationGet extends AbstractRequest {

    @SpotifyRequestField
    private final String[] seed_artists;
    @SpotifyRequestField
    private final String[] seed_genres;
    @SpotifyRequestField
    private final String[] seed_tracks;


    @SpotifyRequestField
    private int limit;
    @SpotifyRequestField
    private Country market;


    @SpotifyRequestField
    private double max_acousticness, min_acousticness;
    @SpotifyRequestField
    private double max_danceability, min_danceability;
    @SpotifyRequestField
    private double max_energy, min_energy;
    @SpotifyRequestField
    private double max_instrumentalness, min_instrumentalness;
    @SpotifyRequestField
    private double max_liveness, min_liveness;
    @SpotifyRequestField
    private double max_loudness, min_loudness;
    @SpotifyRequestField
    private double max_speechiness, min_speechiness;
    @SpotifyRequestField
    private double max_tempo, min_tempo;
    @SpotifyRequestField
    private double max_valence, min_valence;


    @SpotifyRequestField
    private int max_duration_ms, min_duration_ms;
    @SpotifyRequestField
    private int max_key, min_key;
    @SpotifyRequestField
    private int max_mode, min_mode;
    @SpotifyRequestField
    private int max_popularity, min_popularity;
    @SpotifyRequestField
    private int max_time_signature, min_time_signature;


    @SpotifyRequestField
    private double target_acousticness;
    @SpotifyRequestField
    private double target_danceability;
    @SpotifyRequestField
    private double target_energy;
    @SpotifyRequestField
    private double target_instrumentalness;
    @SpotifyRequestField
    private double target_liveness;
    @SpotifyRequestField
    private double target_loudness;
    @SpotifyRequestField
    private double target_speechiness;
    @SpotifyRequestField
    private double target_tempo;
    @SpotifyRequestField
    private double target_valence;


    @SpotifyRequestField
    private int target_duration_ms;
    @SpotifyRequestField
    private int target_key;
    @SpotifyRequestField
    private int target_mode;
    @SpotifyRequestField
    private int target_popularity;
    @SpotifyRequestField
    private int target_time_signature;


    /**
     * @param seedArtists The array of seed artists (up to 5) to generate a recommendation
     * @param seedGenres  The array of seed genres (up to 5) to generate a recommendation
     * @param seedTracks  The array of seed tracks (up to 5) to generate a recommendation
     */
    public TrackRecommendationGet(String[] seedArtists, String[] seedGenres, String[] seedTracks) {
        this.seed_artists = seedArtists;
        this.seed_genres = seedGenres;
        this.seed_tracks = seedTracks;
        try {
            for (Field field : this.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                Class<?> type = field.getType();
                if (type.equals(int.class) || type.equals(double.class)) {
                    field.set(this, -1);
                }
            }
        } catch (IllegalAccessException e) {
            System.out.println("Failed to instantiate default values.");
            e.printStackTrace();
        }
    }


    /**
     * @param maxs maps array to field order in class
     *             max_acousticness, max_danceability, max_energy, max_instrumentalness, max_liveness, max_loudness, max_speechiness, max_tempo, max_valence, max_duration_ms, max_key, max_mode, max_popularity, max_time_signature
     *             0               , 1               , 2         , 3, ...
     */
    public void setMaximums(double[] maxs) {
        if (maxs.length != 14)
            throw new IndexOutOfBoundsException(String.format("Failed to set maximums should be size 14 found size %s.", maxs.length));

        this.setGenericFields(maxs, "max_");
    }

    public void setMinimums(double[] mins) {
        if (mins.length != 14)
            throw new IndexOutOfBoundsException(String.format("Failed to set minimums should be size 14 found size %s.", mins.length));

        this.setGenericFields(mins, "min_");
    }

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

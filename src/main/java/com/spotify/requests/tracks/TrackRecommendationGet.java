package com.spotify.requests.tracks;

import com.spotify.objects.wrappers.Market;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;


/**
 * Recommendations are generated based on the available information for a given seed entity and matched against similar artists and tracks.
 * If there is sufficient information about the provided seeds, a list of tracks will be returned together with pool size details.
 * For artists and tracks that are very new or obscure there might not be enough data to generate a list of tracks.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/#/operations/get-recommendations">Spotify Docs</a>
 */
@SpotifyRequest("recommendations")
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
    private Market market;


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


    public void setLimit(int limit) {
        this.limit = limit;
    }

    public void setMarket(Market market) {
        this.market = market;
    }

    public void setMax_acousticness(double max_acousticness) {
        this.max_acousticness = max_acousticness;
    }

    public void setMin_acousticness(double min_acousticness) {
        this.min_acousticness = min_acousticness;
    }

    public void setMax_danceability(double max_danceability) {
        this.max_danceability = max_danceability;
    }

    public void setMin_danceability(double min_danceability) {
        this.min_danceability = min_danceability;
    }

    public void setMax_energy(double max_energy) {
        this.max_energy = max_energy;
    }

    public void setMin_energy(double min_energy) {
        this.min_energy = min_energy;
    }

    public void setMax_instrumentalness(double max_instrumentalness) {
        this.max_instrumentalness = max_instrumentalness;
    }

    public void setMin_instrumentalness(double min_instrumentalness) {
        this.min_instrumentalness = min_instrumentalness;
    }

    public void setMax_liveness(double max_liveness) {
        this.max_liveness = max_liveness;
    }

    public void setMin_liveness(double min_liveness) {
        this.min_liveness = min_liveness;
    }

    public void setMax_loudness(double max_loudness) {
        this.max_loudness = max_loudness;
    }

    public void setMin_loudness(double min_loudness) {
        this.min_loudness = min_loudness;
    }

    public void setMax_speechiness(double max_speechiness) {
        this.max_speechiness = max_speechiness;
    }

    public void setMin_speechiness(double min_speechiness) {
        this.min_speechiness = min_speechiness;
    }

    public void setMax_tempo(double max_tempo) {
        this.max_tempo = max_tempo;
    }

    public void setMin_tempo(double min_tempo) {
        this.min_tempo = min_tempo;
    }

    public void setMax_valence(double max_valence) {
        this.max_valence = max_valence;
    }

    public void setMin_valence(double min_valence) {
        this.min_valence = min_valence;
    }

    public void setMax_duration_ms(int max_duration_ms) {
        this.max_duration_ms = max_duration_ms;
    }

    public void setMin_duration_ms(int min_duration_ms) {
        this.min_duration_ms = min_duration_ms;
    }

    public void setMax_key(int max_key) {
        this.max_key = max_key;
    }

    public void setMin_key(int min_key) {
        this.min_key = min_key;
    }

    public void setMax_mode(int max_mode) {
        this.max_mode = max_mode;
    }

    public void setMin_mode(int min_mode) {
        this.min_mode = min_mode;
    }

    public void setMax_popularity(int max_popularity) {
        this.max_popularity = max_popularity;
    }

    public void setMin_popularity(int min_popularity) {
        this.min_popularity = min_popularity;
    }

    public void setMax_time_signature(int max_time_signature) {
        this.max_time_signature = max_time_signature;
    }

    public void setMin_time_signature(int min_time_signature) {
        this.min_time_signature = min_time_signature;
    }

    public void setTarget_acousticness(double target_acousticness) {
        this.target_acousticness = target_acousticness;
    }

    public void setTarget_danceability(double target_danceability) {
        this.target_danceability = target_danceability;
    }

    public void setTarget_energy(double target_energy) {
        this.target_energy = target_energy;
    }

    public void setTarget_instrumentalness(double target_instrumentalness) {
        this.target_instrumentalness = target_instrumentalness;
    }

    public void setTarget_liveness(double target_liveness) {
        this.target_liveness = target_liveness;
    }

    public void setTarget_loudness(double target_loudness) {
        this.target_loudness = target_loudness;
    }

    public void setTarget_speechiness(double target_speechiness) {
        this.target_speechiness = target_speechiness;
    }

    public void setTarget_tempo(double target_tempo) {
        this.target_tempo = target_tempo;
    }

    public void setTarget_valence(double target_valence) {
        this.target_valence = target_valence;
    }

    public void setTarget_duration_ms(int target_duration_ms) {
        this.target_duration_ms = target_duration_ms;
    }

    public void setTarget_key(int target_key) {
        this.target_key = target_key;
    }

    public void setTarget_mode(int target_mode) {
        this.target_mode = target_mode;
    }

    public void setTarget_popularity(int target_popularity) {
        this.target_popularity = target_popularity;
    }

    public void setTarget_time_signature(int target_time_signature) {
        this.target_time_signature = target_time_signature;
    }
}

package dev.gruncan.spotify.objects.tracks;

import dev.gruncan.spotify.objects.SpotifyField;
import dev.gruncan.spotify.objects.SpotifyObject;
import dev.gruncan.spotify.objects.SpotifyOptional;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents a recommendation seed
 *
 * @see TrackRecommendation
 * @see SpotifyObject
 */
@Getter
@Setter
@SpotifyOptional
public class RecommendationSeed implements SpotifyObject {

    /**
     * The number of tracks available after min_* and max_* filters have been applied.
     */
    @SpotifyField
    private int afterFilteringSize;

    /**
     * The number of tracks available after relinking for regional availability.
     */
    @SpotifyField
    private int afterRelinkingSize;

    /**
     * A link to the full track or artist data for this seed. For tracks this will be a link to a Track Object.
     * For artists a link to an Artist Object. For genre seeds, this value will be null.
     */
    @SpotifyField
    private String href;

    /**
     * The id used to select this seed. This will be the same as the string used in the seed_artists, seed_tracks or seed_genres parameter.
     */
    @SpotifyField
    private String id;

    /**
     * The number of recommended tracks available for this seed.
     */
    @SpotifyField
    private int initialPoolSize;

    /**
     * The entity type of this seed. One of artist, track or genre.
     */
    @SpotifyField
    private String type;

}

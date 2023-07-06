package dev.gruncan.spotify.objects.tracks;

import dev.gruncan.spotify.objects.SpotifyField;
import dev.gruncan.spotify.objects.SpotifyObject;
import dev.gruncan.spotify.requests.tracks.TrackRecommendationGet;
import lombok.Getter;
import lombok.Setter;


/**
 * Represents the tracks of a playlist
 * Serialized from <a href="https://developer.spotify.com/documentation/web-api/reference/get-recommendations">TrackRecommendationGet</a>
 *
 * @see TrackRecommendationGet
 * @see RecommendationSeed
 * @see Track
 * @see SpotifyObject
 */
@Getter
@Setter
public class TrackRecommendation implements SpotifyObject {

    /**
     * An array of recommendation seed objects.
     */
    @SpotifyField
    private RecommendationSeed[] seeds;

    /**
     * An array of track object (simplified) ordered according to the parameters supplied.
     */
    @SpotifyField
    private Track[] tracks;


}

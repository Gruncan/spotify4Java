package dev.gruncan.spotify.objects.genres;

import dev.gruncan.spotify.objects.SpotifyField;
import dev.gruncan.spotify.objects.SpotifyObject;
import dev.gruncan.spotify.requests.genres.GenreAvailableGet;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents genres seeds<br>
 * Serialized from <a href="https://developer.spotify.com/documentation/web-api/reference/get-recommendation-genres">GenreAvailableGet</a>
 *
 * @see GenreAvailableGet
 * @see SpotifyObject
 */
@Getter
@Setter
public class GenreSeeds implements SpotifyObject {

    /**
     * An array of {@link String} genres
     */
    @SpotifyField
    private String[] genres;

}

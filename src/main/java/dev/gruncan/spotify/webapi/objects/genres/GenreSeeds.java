package dev.gruncan.spotify.webapi.objects.genres;

import dev.gruncan.spotify.webapi.objects.SpotifyField;
import dev.gruncan.spotify.webapi.objects.SpotifyObject;
import dev.gruncan.spotify.webapi.requests.genres.GenreAvailableGet;
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

package com.spotify.objects.genres;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import com.spotify.requests.genres.GenreAvailableGet;
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

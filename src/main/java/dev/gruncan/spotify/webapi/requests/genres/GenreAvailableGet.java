package dev.gruncan.spotify.webapi.requests.genres;

import dev.gruncan.spotify.SpotifyResponse;
import dev.gruncan.spotify.webapi.objects.SpotifySerialize;
import dev.gruncan.spotify.webapi.objects.genres.GenreSeeds;
import dev.gruncan.spotify.webapi.requests.SpotifyRequest;
import dev.gruncan.spotify.webapi.requests.SpotifyRequestVariant;
import lombok.Setter;

/**
 * Retrieve a list of available genres seed parameter values for recommendations.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/get-recommendation-genres">Spotify Docs</a>
 * <p>Serializes into {@link GenreSeeds} array</p>
 *
 * @see GenreSeeds
 * @see SpotifyRequestVariant
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@Setter
@SpotifyRequest("recommendations/available-genre-seeds")
@SpotifySerialize(GenreSeeds.class)
public class GenreAvailableGet implements SpotifyRequestVariant {

}

package com.spotify.requests.genres;

import com.spotify.SpotifyResponse;
import com.spotify.objects.SpotifySerialize;
import com.spotify.objects.genres.GenreSeeds;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.SpotifyRequest;
import lombok.Setter;

/**
 * Retrieve a list of available genres seed parameter values for recommendations.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/get-recommendation-genres">Spotify Docs</a>
 * <p>Serializes into {@link GenreSeeds} array</p>
 *
 * @see GenreSeeds
 * @see AbstractRequest
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@Setter
@SpotifyRequest("recommendations/available-genre-seeds")
@SpotifySerialize(GenreSeeds.class)
public class GenreAvailableGet extends AbstractRequest {

}

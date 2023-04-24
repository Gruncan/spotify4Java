package com.spotify.requests.markets;

import com.spotify.SpotifyResponse;
import com.spotify.objects.SpotifySerialize;
import com.spotify.objects.wrappers.Country;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.SpotifyRequest;

/**
 * Get the list of markets where Spotify is available.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/get-available-markets">Spotify Docs</a>
 * <p>Serializes into {@link Country} array</p>
 *
 * @see Country
 * @see AbstractRequest
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@SpotifyRequest("markets")
@SpotifySerialize(value = Country.class, isArray = true)
public class MarketsAvailableGet extends AbstractRequest {

}

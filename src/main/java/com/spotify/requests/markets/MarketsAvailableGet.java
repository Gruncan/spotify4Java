package com.spotify.requests.markets;

import com.spotify.SpotifyResponse;
import com.spotify.objects.SpotifySerialize;
import com.spotify.objects.markets.Markets;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestVariant;

/**
 * Get the list of markets where Spotify is available.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/get-available-markets">Spotify Docs</a>
 * <p>Serializes into {@link Markets} array</p>
 *
 * @see Markets
 * @see SpotifyRequestVariant
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@SpotifyRequest("markets")
@SpotifySerialize(Markets.class)
public class MarketsAvailableGet implements SpotifyRequestVariant {

}

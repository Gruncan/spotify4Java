package dev.gruncan.spotify.webapi.requests.markets;

import dev.gruncan.spotify.SpotifyResponse;
import dev.gruncan.spotify.webapi.objects.SpotifySerialize;
import dev.gruncan.spotify.webapi.objects.markets.Markets;
import dev.gruncan.spotify.webapi.requests.SpotifyRequest;
import dev.gruncan.spotify.webapi.requests.SpotifyRequestVariant;

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

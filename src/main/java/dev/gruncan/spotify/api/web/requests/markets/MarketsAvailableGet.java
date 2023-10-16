package dev.gruncan.spotify.api.web.requests.markets;

import dev.gruncan.spotify.SpotifyResponse;
import dev.gruncan.spotify.api.web.objects.SpotifySerialize;
import dev.gruncan.spotify.api.web.objects.markets.Markets;
import dev.gruncan.spotify.api.SpotifyRequest;
import dev.gruncan.spotify.api.SpotifyRequestVariant;

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

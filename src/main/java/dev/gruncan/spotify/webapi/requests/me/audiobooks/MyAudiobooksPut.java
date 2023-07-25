package dev.gruncan.spotify.webapi.requests.me.audiobooks;


import dev.gruncan.http.HttpMethod;
import dev.gruncan.spotify.SpotifyResponse;
import dev.gruncan.spotify.webapi.objects.SpotifySerialize;
import dev.gruncan.spotify.webapi.requests.SpotifyRequest;
import dev.gruncan.spotify.webapi.requests.SpotifyRequestField;
import dev.gruncan.spotify.webapi.requests.SpotifyRequestVariant;
import dev.gruncan.spotify.webapi.requests.util.Scope;

/**
 * Save one or more audiobooks to the current Spotify user's library.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/save-audiobooks-user">Spotify Docs</a>
 *
 * @see SpotifyRequestVariant
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@SpotifyRequest(value = "me/audiobooks", authorizations = Scope.USER_LIBRARY_MODIFY, method = HttpMethod.PUT)
public class MyAudiobooksPut implements SpotifyRequestVariant {

    /**
     * A list of the Spotify IDs.
     */
    @SpotifyRequestField
    private final String[] ids;


    /**
     * Initializes the {@link MyAudiobooksPut} request
     *
     * @param ids The Spotify IDS of the audiobooks.
     */
    public MyAudiobooksPut(String... ids) {
        this.ids = ids;
    }
}

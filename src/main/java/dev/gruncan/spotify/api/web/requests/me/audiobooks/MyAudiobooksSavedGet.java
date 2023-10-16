package dev.gruncan.spotify.api.web.requests.me.audiobooks;

import dev.gruncan.spotify.SpotifyResponse;
import dev.gruncan.spotify.api.web.objects.SpotifySerialize;
import dev.gruncan.spotify.api.SpotifyRequest;
import dev.gruncan.spotify.api.SpotifyRequestField;
import dev.gruncan.spotify.api.SpotifyRequestVariant;
import dev.gruncan.spotify.api.web.requests.util.Scope;


/**
 * Check if one or more audiobooks are already saved in the current Spotify user's library.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/check-users-saved-audiobooks">Spotify Docs</a>
 *
 * @see SpotifyRequestVariant
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@SpotifyRequest(value = "me/audiobooks/contains", authorizations = Scope.USER_LIBRARY_READ)
public class MyAudiobooksSavedGet implements SpotifyRequestVariant {

    /**
     * A list of the Spotify IDs
     */
    @SpotifyRequestField
    private final String[] ids;


    /**
     * Initializes the {@link MyAudiobooksSavedGet} request
     *
     * @param ids The Spotify IDS of the audiobooks.
     */
    public MyAudiobooksSavedGet(String... ids) {
        this.ids = ids;
    }
}

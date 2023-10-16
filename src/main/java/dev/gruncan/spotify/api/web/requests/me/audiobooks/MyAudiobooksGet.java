package dev.gruncan.spotify.api.web.requests.me.audiobooks;

import dev.gruncan.spotify.SpotifyResponse;
import dev.gruncan.spotify.api.web.objects.SpotifySerialize;
import dev.gruncan.spotify.api.web.objects.audiobooks.Audiobooks;
import dev.gruncan.spotify.api.SpotifyRequest;
import dev.gruncan.spotify.api.SpotifyRequestField;
import dev.gruncan.spotify.api.SpotifyRequestVariant;
import dev.gruncan.spotify.api.web.requests.util.Scope;
import lombok.Setter;

/**
 * Get a list of the audiobooks saved in the current Spotify user's 'Your Music' library.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/get-users-saved-audiobooks">Spotify Docs</a>
 * <p>Serializes into {@link Audiobooks}</p>
 *
 * @see Audiobooks
 * @see SpotifyRequestVariant
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@Setter
@SpotifyRequest(value = "me/audiobooks", authorizations = Scope.USER_LIBRARY_READ)
@SpotifySerialize(Audiobooks.class)
public class MyAudiobooksGet implements SpotifyRequestVariant {

    /**
     * The maximum number of items to return. Default: 20. Minimum: 1. Maximum: 50.
     */
    @SpotifyRequestField
    private int limit;

    /**
     * The index of the first item to return. Default: 0 (the first item). Use with limit to get the next set of items.
     */
    @SpotifyRequestField
    private int offset;

}

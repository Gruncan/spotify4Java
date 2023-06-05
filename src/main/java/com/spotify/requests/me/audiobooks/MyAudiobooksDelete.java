package com.spotify.requests.me.audiobooks;

import com.http.HttpMethod;
import com.spotify.SpotifyResponse;
import com.spotify.objects.SpotifySerialize;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;
import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.util.Scope;

/**
 * Remove one or more audiobooks from the Spotify user's library.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/remove-audiobooks-user">Spotify Docs</a>
 *
 * @see SpotifyRequestVariant
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@SpotifyRequest(value = "me/audiobooks", authorizations = Scope.USER_LIBRARY_MODIFY, method = HttpMethod.DELETE)
public class MyAudiobooksDelete implements SpotifyRequestVariant {

    /**
     * A list of the Spotify IDs.
     */
    @SpotifyRequestField
    private final String[] ids;

    /**
     * Initializes the {@link MyAudiobooksDelete} request
     *
     * @param ids The Spotify IDS of the audiobooks.
     */
    public MyAudiobooksDelete(String... ids) {
        this.ids = ids;
    }
}

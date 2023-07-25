package dev.gruncan.spotify.exceptions;

import dev.gruncan.spotify.webapi.requests.SpotifyRequestExecutor;

/**
 * Thrown when a URL for a request is fail to be built.
 *
 * @see SpotifyRequestExecutor
 */
public class SpotifyUrlParserException extends Exception {

    public SpotifyUrlParserException(String reason) {
        super(reason);
    }

}

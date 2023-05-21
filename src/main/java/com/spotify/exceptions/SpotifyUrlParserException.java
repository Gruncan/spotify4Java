package com.spotify.exceptions;

import com.spotify.requests.AbstractRequest;

/**
 * Thrown when a URL for a request is fail to be built.
 * @see AbstractRequest
 */
public class SpotifyUrlParserException extends Exception {

    public SpotifyUrlParserException(String reason) {
        super(reason);
    }

}

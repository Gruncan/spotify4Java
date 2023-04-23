/*
 * Written by Gruncan for spotify4Java (https://github.com/Gruncan/spotify4Java/)
 *  20/04/23
 */
package com.spotify.exceptions;

/**
 * Thrown when a URL for a request is fail to be built.
 */
public class SpotifyUrlParserException extends Exception {

    public SpotifyUrlParserException(String reason) {
        super(reason);
    }

}

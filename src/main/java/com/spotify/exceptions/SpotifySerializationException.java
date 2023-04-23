/*
 * Written by Gruncan for spotify4Java (https://github.com/Gruncan/spotify4Java/)
 *  26/09/22
 */
package com.spotify.exceptions;

/**
 * Thrown to indicate that given the specified JSON was unable to be serialized into provided object.
 */
public class SpotifySerializationException extends Exception {


    public SpotifySerializationException(String reason) {
        super(reason);
    }
}

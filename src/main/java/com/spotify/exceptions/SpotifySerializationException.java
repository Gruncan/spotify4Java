package com.spotify.exceptions;

import com.spotify.objects.SpotifySerializer;

/**
 * Thrown to indicate that given the specified JSON was unable to be serialized into provided object.
 * @see SpotifySerializer
 */
public class SpotifySerializationException extends Exception {


    public SpotifySerializationException(String reason) {
        super(reason);
    }
}

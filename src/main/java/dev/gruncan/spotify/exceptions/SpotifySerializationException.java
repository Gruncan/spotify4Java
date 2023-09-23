package dev.gruncan.spotify.exceptions;

import dev.gruncan.spotify.api.web.objects.SpotifySerializer;

/**
 * Thrown to indicate that given the specified JSON was unable to be serialized into provided object.
 * @see SpotifySerializer
 */
public class SpotifySerializationException extends Exception {


    public SpotifySerializationException(String reason) {
        super(reason);
    }
}

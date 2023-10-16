package dev.gruncan.spotify.api.web.requests.playlists;

import dev.gruncan.spotify.SpotifyResponse;
import dev.gruncan.spotify.api.web.objects.SpotifySerialize;
import dev.gruncan.spotify.api.web.objects.wrappers.SpotifyImage;
import dev.gruncan.spotify.api.SpotifyRequest;
import dev.gruncan.spotify.api.SpotifyRequestVariant;
import dev.gruncan.spotify.api.SpotifySubRequest;

/**
 * Get the current image associated with a specific playlist.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/get-playlist-cover">Spotify Docs</a>
 * <p>Serializes into {@link SpotifyImage}</p>
 *
 * @see SpotifyImage
 * @see SpotifyRequestVariant
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@SpotifyRequest(value = "playlists", end = "images")
@SpotifySerialize(value = SpotifyImage.class, isArray = true)
public class PlaylistImageGet implements SpotifyRequestVariant {

    /**
     * The Spotify ID of the playlist.
     */
    @SpotifySubRequest
    private final String id;

    /**
     * Initializes the {@link PlaylistImageGet} request
     * @param id The Spotify ID of the playlist.
     */
    public PlaylistImageGet(String id) {
        this.id = id;
    }
}

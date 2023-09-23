package dev.gruncan.spotify.api.web.requests.tracks;

import dev.gruncan.spotify.SpotifyResponse;
import dev.gruncan.spotify.api.web.objects.SpotifySerialize;
import dev.gruncan.spotify.api.web.objects.tracks.Track;
import dev.gruncan.spotify.api.web.objects.wrappers.Country;
import dev.gruncan.spotify.api.web.requests.SpotifyRequest;
import dev.gruncan.spotify.api.web.requests.SpotifyRequestField;
import dev.gruncan.spotify.api.web.requests.SpotifyRequestVariant;
import dev.gruncan.spotify.api.web.requests.SpotifySubRequest;
import lombok.Setter;

/**
 * Get Spotify catalog information for a single album.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/get-track">Spotify Docs</a>
 * <p>Serializes into {@link Track}</p>
 *
 * @see Track
 * @see SpotifyRequestVariant
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@Setter
@SpotifyRequest("tracks")
@SpotifySerialize(Track.class)
public class TrackGet implements SpotifyRequestVariant {


    /**
     * The Spotify ID for the track.
     */
    @SpotifySubRequest
    private final String id;

    /**
     * An ISO 3166-1 alpha-2 country code. If a country code is specified, only content that is available in that market will be returned.
     */
    @SpotifyRequestField
    private Country market;

    /**
     * Initializes the {@link TrackGet} request
     * @param id The Spotify ID for the track.
     */
    public TrackGet(String id) {
        this.id = id;
    }

}

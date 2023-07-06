package dev.gruncan.spotify.requests.tracks;

import dev.gruncan.spotify.SpotifyResponse;
import dev.gruncan.spotify.objects.SpotifySerialize;
import dev.gruncan.spotify.objects.albums.Album;
import dev.gruncan.spotify.objects.tracks.Track;
import dev.gruncan.spotify.objects.wrappers.Country;
import dev.gruncan.spotify.requests.SpotifyRequest;
import dev.gruncan.spotify.requests.SpotifyRequestField;
import dev.gruncan.spotify.requests.SpotifyRequestVariant;
import lombok.Setter;


/**
 * Get Spotify catalog information for multiple tracks based on their Spotify IDs.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/get-several-tracks">Spotify Docs</a>
 * <p>Serializes into {@link Track} array</p>
 *
 * @see Album
 * @see SpotifyRequestVariant
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@Setter
@SpotifyRequest("tracks")
@SpotifySerialize(value = Track.class, isArray = true)
public class TrackSeveralGet implements SpotifyRequestVariant {

    /**
     * A list of the Spotify IDs.
     */
    @SpotifyRequestField
    private final String[] ids;

    /**
     * An ISO 3166-1 alpha-2 country code. If a country code is specified, only content that is available in that market will be returned.
     */
    @SpotifyRequestField
    private Country market;


    /**
     * Initializes the {@link TrackSeveralGet} request
     * @param ids A list of the Spotify IDs.
     */
    public TrackSeveralGet(String... ids) {
        this.ids = ids;
    }

}

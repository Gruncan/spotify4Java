package com.spotify.requests.episodes;

import com.spotify.SpotifyResponse;
import com.spotify.objects.SpotifySerialize;
import com.spotify.objects.albums.Album;
import com.spotify.objects.episodes.Episode;
import com.spotify.objects.wrappers.Country;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;
import com.spotify.requests.SpotifySubRequest;
import com.spotify.requests.albums.SeveralAlbumsGet;
import lombok.Setter;

/**
 * Get Spotify catalog information for a single episode identified by its unique Spotify ID.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/get-an-episode">Spotify Docs</a>
 * <p>Serializes into {@link Episode}</p>
 *
 * @see Episode
 * @see AbstractRequest
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@Setter
@SpotifyRequest("episodes")
@SpotifySerialize(Episode.class)
//TODO permissions
public class EpisodeGet extends AbstractRequest {

    /**
     * The Spotify ID for the episode.
     */
    @SpotifySubRequest
    private final String id;

    /**
     * An ISO 3166-1 alpha-2 country code. If a country code is specified, only content that is available in that market will be returned.
     */
    @SpotifyRequestField
    private Country market;


    /**
     * Initializes the {@link EpisodeGet} request
     * @param id The Spotify ID for the episode.
     */
    public EpisodeGet(String id) {
        this.id = id;
    }

}

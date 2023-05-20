package com.spotify.requests.shows;

import com.spotify.SpotifyResponse;
import com.spotify.objects.SpotifySerialize;
import com.spotify.objects.shows.SimplifiedShow;
import com.spotify.objects.wrappers.Country;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;
import com.spotify.requests.SpotifySubRequest;
import lombok.Setter;

/**
 * Get Spotify catalog information for several shows based on their Spotify IDs.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/get-multiple-shows">Spotify Docs</a>
 * <p>Serializes into {@link SimplifiedShow}</p>
 *
 * @see SimplifiedShow
 * @see AbstractRequest
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@Setter
@SpotifyRequest("shows")
@SpotifySerialize(value = SimplifiedShow.class, isArray = true)
public class SeveralShowsGet extends AbstractRequest {


    /**
     * A list of the Spotify IDs for the shows. Maximum: 50 IDs.
     */
    @SpotifySubRequest
    private final String[] ids;

    /**
     * An ISO 3166-1 alpha-2 country code. If a country code is specified, only content that is available in that market will be returned.
     */
    @SpotifyRequestField
    private Country market;

    /**
     * Initializes the {@link SeveralShowsGet} request
     * @param ids A list of the Spotify IDs for the shows. Maximum: 50 IDs.
     */
    public SeveralShowsGet(String... ids) {
        this.ids = ids;
    }

}

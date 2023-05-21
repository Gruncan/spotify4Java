package com.spotify.objects.markets;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import com.spotify.objects.wrappers.Country;
import com.spotify.requests.markets.MarketsAvailableGet;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents spotify markets <br>
 * Serialized from <a href="https://developer.spotify.com/documentation/web-api/reference/get-available-markets">MarketsAvailableGet</a>
 *
 * @see MarketsAvailableGet
 * @see Country
 * @see SpotifyObject
 */
@Setter
@Getter
public class Markets implements SpotifyObject {

    /**
     * An array of {@link Country} markets available
     */
    @SpotifyField
    private Country[] markets;

}

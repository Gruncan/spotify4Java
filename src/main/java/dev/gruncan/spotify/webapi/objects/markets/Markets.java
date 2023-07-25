package dev.gruncan.spotify.webapi.objects.markets;

import dev.gruncan.spotify.webapi.objects.SpotifyField;
import dev.gruncan.spotify.webapi.objects.SpotifyObject;
import dev.gruncan.spotify.webapi.objects.wrappers.Country;
import dev.gruncan.spotify.webapi.requests.markets.MarketsAvailableGet;
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

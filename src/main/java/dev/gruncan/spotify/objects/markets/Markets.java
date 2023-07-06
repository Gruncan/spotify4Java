package dev.gruncan.spotify.objects.markets;

import dev.gruncan.spotify.objects.SpotifyField;
import dev.gruncan.spotify.objects.SpotifyObject;
import dev.gruncan.spotify.objects.wrappers.Country;
import dev.gruncan.spotify.requests.markets.MarketsAvailableGet;
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

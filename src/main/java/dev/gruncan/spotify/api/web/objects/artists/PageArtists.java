package dev.gruncan.spotify.api.web.objects.artists;

import dev.gruncan.spotify.api.web.objects.SpotifyField;
import dev.gruncan.spotify.api.web.objects.SpotifyObject;
import dev.gruncan.spotify.api.web.requests.me.MyFollowedArtistsGet;
import lombok.Getter;


/**
 * Represents a spotify page set of albums<br>
 * Serialized from <a href="https://developer.spotify.com/documentation/web-api/reference/get-followed">MyFollowedArtistsGet</a>
 *
 * @see MyFollowedArtistsGet
 * @see Artists
 * @see SpotifyObject
 */
@Getter
public class PageArtists implements SpotifyObject {

    /**
     * The artists inner object of the response
     */
    @SpotifyField
    private Artists artists;

}

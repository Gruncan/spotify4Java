package dev.gruncan.spotify.api.web.objects.episodes;

import dev.gruncan.spotify.api.web.objects.SpotifyField;
import dev.gruncan.spotify.api.web.objects.SpotifyObject;
import dev.gruncan.spotify.api.web.objects.shows.Show;
import dev.gruncan.spotify.api.web.objects.shows.ShowEpisodesSearch;
import dev.gruncan.spotify.api.web.objects.wrappers.AbstractSpotifyCompilation;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents a spotify SimplifiedEpisodeObject
 *
 * @see Episode
 * @see ShowEpisodesSearch
 * @see Show
 * @see SpotifyObject
 * @see AbstractSpotifyCompilation
 */
@Getter
@Setter
public class SimplifiedEpisode extends AbstractSpotifyCompilation implements SpotifyObject {


    /**
     * True if the episode is hosted outside of Spotify's CDN.
     */
    @SpotifyField("is_externally_hosted")
    private boolean isExternallyHosted;


}

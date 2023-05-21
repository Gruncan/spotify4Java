package com.spotify.objects.episodes;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import com.spotify.objects.shows.Show;
import com.spotify.objects.shows.ShowEpisodesSearch;
import com.spotify.objects.wrappers.AbstractSpotifyCompilation;
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

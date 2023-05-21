package com.spotify.objects.episodes;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import com.spotify.objects.albums.SimplifiedAlbum;
import com.spotify.objects.shows.Show;
import com.spotify.requests.episodes.EpisodeGet;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents a spotify episode<br>
 * Serialized from <a href="https://developer.spotify.com/documentation/web-api/reference/get-an-episode">EpisodeGet</a>
 *
 * @see EpisodeGet
 * @see SimplifiedAlbum
 * @see Show
 * @see SpotifyObject
 */
@Setter
@Getter
public class Episode extends SimplifiedEpisode implements SpotifyObject {

    /**
     * The show on which the episode belongs.
     */
    @SpotifyField
    private Show show;

}

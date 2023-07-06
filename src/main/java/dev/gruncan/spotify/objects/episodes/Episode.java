package dev.gruncan.spotify.objects.episodes;

import dev.gruncan.spotify.objects.SpotifyField;
import dev.gruncan.spotify.objects.SpotifyObject;
import dev.gruncan.spotify.objects.albums.SimplifiedAlbum;
import dev.gruncan.spotify.objects.shows.Show;
import dev.gruncan.spotify.requests.episodes.EpisodeGet;
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

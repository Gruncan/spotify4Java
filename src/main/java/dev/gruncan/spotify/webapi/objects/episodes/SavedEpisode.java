package dev.gruncan.spotify.webapi.objects.episodes;

import dev.gruncan.spotify.webapi.objects.SpotifyField;
import dev.gruncan.spotify.webapi.objects.SpotifyObject;
import lombok.Getter;

/**
 * Represents a saved episode
 *
 * @see EpisodePage
 * @see Episode
 * @see SpotifyObject
 */
@Getter
public class SavedEpisode implements SpotifyObject {

    /**
     * The date and time the episode was saved. Timestamps are returned in ISO 8601 format as Coordinated Universal Time (UTC) with a zero offset: YYYY-MM-DDTHH:MM:SSZ.
     */
    @SpotifyField("added_at")
    private String addedAt;

    /**
     * Information about the episode.
     */
    @SpotifyField
    private Episode episode;

}

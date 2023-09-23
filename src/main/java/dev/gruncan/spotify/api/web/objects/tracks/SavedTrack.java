package dev.gruncan.spotify.api.web.objects.tracks;

import dev.gruncan.spotify.api.web.objects.SpotifyField;
import dev.gruncan.spotify.api.web.objects.SpotifyObject;
import lombok.Getter;

/**
 * Represents a SavedTrack
 *
 * @see TrackSavedPage
 * @see Track
 * @see SpotifyObject
 */
@Getter
public class SavedTrack implements SpotifyObject {

    /**
     * The date and time the track was saved. Timestamps are returned in ISO 8601 format as Coordinated Universal Time (UTC) with a zero offset: YYYY-MM-DDTHH:MM:SSZ. If the time is imprecise (for example, the date/time of an album release), an additional field indicates the precision; see for example, release_date in an album object.
     */
    @SpotifyField("added_at")
    private String addedAt;

    /**
     * Information about the track.
     */
    @SpotifyField
    private Track track;


}

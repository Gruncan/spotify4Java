package dev.gruncan.spotify.webapi.objects.player;

import dev.gruncan.spotify.webapi.objects.SpotifyField;
import dev.gruncan.spotify.webapi.objects.SpotifyObject;
import dev.gruncan.spotify.webapi.objects.tracks.Track;
import dev.gruncan.spotify.webapi.objects.tracks.TrackPage;
import lombok.Getter;


/**
 * Represents a history of a track that was played
 *
 * @see TrackPage
 * @see Track
 * @see PlayerContext
 * @see SpotifyObject
 */
@Getter
public class PlayTrackHistory implements SpotifyObject {

    /**
     * The track the user listened to.
     */
    @SpotifyField
    private Track track;

    /**
     * The date and time the track was played.
     */
    @SpotifyField("played_at")
    private String playedAt;

    /**
     * The context the track was played from.
     */
    @SpotifyField
    private PlayerContext context;

}

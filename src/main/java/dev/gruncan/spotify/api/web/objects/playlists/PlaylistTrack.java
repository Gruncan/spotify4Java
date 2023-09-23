package dev.gruncan.spotify.api.web.objects.playlists;

import dev.gruncan.spotify.api.web.objects.SpotifyField;
import dev.gruncan.spotify.api.web.objects.SpotifyObject;
import dev.gruncan.spotify.api.web.objects.SpotifyOptional;
import dev.gruncan.spotify.api.web.objects.episodes.Episode;
import dev.gruncan.spotify.api.web.objects.tracks.Track;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Represents a track or episode in a playlist
 *
 * @see PlaylistTracksSearch
 * @see PlaylistContributor
 * @see SpotifyObject
 */
@Getter
@Setter
@ToString
public class PlaylistTrack implements SpotifyObject {

    /**
     * The date and time the track or episode was added. Note: some very old playlists may return null in this field.
     */
    @SpotifyField("added_at")
    private String addedAt;

    /**
     * The Spotify user who added the track or episode. Note: some very old playlists may return null in this field.
     */
    @SpotifyField("added_by")
    private PlaylistContributor addedBy;

    /**
     * Whether this track or episode is a local file or not.
     */
    @SpotifyField("is_local")
    private boolean isLocal;

    /**
     * Information about the track
     */
    @SpotifyOptional
    @SpotifyField
    private Track track;

    /**
     * Information about the episode.
     */
    @SpotifyOptional
    @SpotifyField
    private Episode episode;

}

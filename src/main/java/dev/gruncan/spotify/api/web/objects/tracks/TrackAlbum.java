package dev.gruncan.spotify.api.web.objects.tracks;

import dev.gruncan.spotify.api.web.objects.SpotifyField;
import dev.gruncan.spotify.api.web.objects.SpotifyObject;
import dev.gruncan.spotify.api.web.objects.albums.SimplifiedAlbum;
import dev.gruncan.spotify.api.web.objects.artists.SimplifiedArtist;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents a album in a track
 *
 * @see SimplifiedAlbum
 * @see Track
 * @see SimplifiedArtist
 * @see SpotifyObject
 */
@Getter
@Setter
public class TrackAlbum extends SimplifiedAlbum implements SpotifyObject {

    /**
     * An array of {@link SimplifiedArtist} for a track album
     */
    @SpotifyField
    private SimplifiedArtist[] artists;
}

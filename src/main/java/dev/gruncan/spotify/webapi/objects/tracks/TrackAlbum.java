package dev.gruncan.spotify.webapi.objects.tracks;

import dev.gruncan.spotify.webapi.objects.SpotifyField;
import dev.gruncan.spotify.webapi.objects.SpotifyObject;
import dev.gruncan.spotify.webapi.objects.albums.SimplifiedAlbum;
import dev.gruncan.spotify.webapi.objects.artists.SimplifiedArtist;
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

package dev.gruncan.spotify.objects.albums;

import dev.gruncan.spotify.objects.SpotifyField;
import dev.gruncan.spotify.objects.SpotifyObject;
import dev.gruncan.spotify.objects.search.AbstractSearchItems;
import dev.gruncan.spotify.objects.tracks.SimplifiedTrack;
import dev.gruncan.spotify.requests.albums.AlbumTracksGet;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents tracks of an album<br>
 * Serialized from <a href="https://developer.spotify.com/documentation/web-api/reference/get-an-albums-tracks">AlbumTracksGet</a>
 *
 * @see AlbumTracksGet
 * @see AbstractSearchItems
 * @see SimplifiedTrack
 * @see SpotifyObject
 */
@Getter
@Setter
public class AlbumTracks extends AbstractSearchItems implements SpotifyObject {


    /**
     * An array of {@link SimplifiedTrack} for an album
     */
    @SpotifyField
    private SimplifiedTrack[] items;

}

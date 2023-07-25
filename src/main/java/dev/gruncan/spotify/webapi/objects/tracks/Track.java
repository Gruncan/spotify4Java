package dev.gruncan.spotify.webapi.objects.tracks;

import dev.gruncan.spotify.webapi.objects.SpotifyField;
import dev.gruncan.spotify.webapi.objects.SpotifyObject;
import dev.gruncan.spotify.webapi.objects.SpotifyOptional;
import dev.gruncan.spotify.webapi.objects.artists.Artist;
import dev.gruncan.spotify.webapi.objects.wrappers.SpotifyExternalID;
import dev.gruncan.spotify.webapi.requests.tracks.TrackGet;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents a spotify track
 * Serialized from <a href="https://developer.spotify.com/documentation/web-api/reference/get-track">TrackGet</a>
 *
 * @see TrackGet
 * @see TrackAlbum
 * @see Artist
 * @see SpotifyExternalID
 * @see SimplifiedTrack
 * @see SpotifyObject
 */
@Getter
@Setter
@SpotifyOptional
public class Track extends SimplifiedTrack implements SpotifyObject {

    /**
     * The album on which the track appears. The album object includes a link in href to full information about the album
     */
    @SpotifyField
    private TrackAlbum album;

    /**
     * The artists who performed the track. Each artist object includes a link in href to more detailed information about the artist.
     */
    @SpotifyField
    private Artist[] artists;

    /**
     * Known external IDs for the track.
     */
    @SpotifyField("external_ids")
    private SpotifyExternalID externalIDs;

    /**
     * The popularity of the track. The value will be between 0 and 100, with 100 being the most popular.
     * The popularity of a track is a value between 0 and 100, with 100 being the most popular.
     * The popularity is calculated by algorithm and is based, in the most part, on the total number of plays the track
     * has had and how recent those plays are.
     * Generally speaking, songs that are being played a lot now will have a higher popularity than songs that were played
     * a lot in the past. Duplicate tracks (e.g. the same track from a single and an album) are rated independently.
     * Artist and album popularity is derived mathematically from track popularity. Note: the popularity value may lag
     * actual popularity by a few days: the value is not updated in real time.
     */
    @SpotifyField
    private int popularity;


}
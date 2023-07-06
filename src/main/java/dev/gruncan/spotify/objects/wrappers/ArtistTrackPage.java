package dev.gruncan.spotify.objects.wrappers;

import dev.gruncan.spotify.objects.SpotifyField;
import dev.gruncan.spotify.objects.SpotifyObject;
import dev.gruncan.spotify.objects.artists.Artist;
import dev.gruncan.spotify.objects.search.AbstractSearchItems;
import dev.gruncan.spotify.objects.tracks.Track;
import dev.gruncan.spotify.requests.me.MyTopInfo;
import lombok.Getter;

/**
 * Represents pages if artists or tracks
 *
 * @see MyTopInfo
 * @see Artist
 * @see Track
 * @see AbstractSearchItems
 * @see SpotifyObject
 */
@Getter
public class ArtistTrackPage extends AbstractSearchItems implements SpotifyObject {


    @SpotifyField(value = "items", canSkip = true)
    private Artist[] artist;

    @SpotifyField(value = "item", canSkip = true)
    private Track[] tracks;
}

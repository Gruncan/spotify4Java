package dev.gruncan.spotify.api.web.objects.wrappers;

import dev.gruncan.spotify.api.web.objects.SpotifyField;
import dev.gruncan.spotify.api.web.objects.SpotifyObject;
import dev.gruncan.spotify.api.web.objects.artists.Artist;
import dev.gruncan.spotify.api.web.objects.search.AbstractSearchItems;
import dev.gruncan.spotify.api.web.objects.tracks.Track;
import dev.gruncan.spotify.api.web.requests.me.MyTopInfo;
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

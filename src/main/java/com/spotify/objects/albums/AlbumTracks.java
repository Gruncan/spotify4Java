package com.spotify.objects.albums;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import com.spotify.objects.search.AbstractSearchItems;
import com.spotify.objects.tracks.SimplifiedTrack;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AlbumTracks extends AbstractSearchItems {


    @SpotifyField
    private SimplifiedTrack[] items;

}

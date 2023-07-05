package com.spotify.objects.tracks;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import lombok.Getter;

@Getter
public class SavedTrack implements SpotifyObject {

    @SpotifyField("added_at")
    private String addedAt;

    @SpotifyField
    private Track track;


}

package com.spotify.objects.shows;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import lombok.Getter;

@Getter
public class SavedShow implements SpotifyObject {

    @SpotifyField("added_at")
    private String addedAt;

    @SpotifyField
    private Show show;

}

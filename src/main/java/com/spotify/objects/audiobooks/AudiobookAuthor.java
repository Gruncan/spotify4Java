package com.spotify.objects.audiobooks;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import lombok.Setter;

@Setter
public class AudiobookAuthor implements SpotifyObject {


    @SpotifyField
    private String name;

}

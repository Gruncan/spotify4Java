package com.spotify.objects.audiobooks;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AudiobookAuthor implements SpotifyObject {


    @SpotifyField
    private String name;

}


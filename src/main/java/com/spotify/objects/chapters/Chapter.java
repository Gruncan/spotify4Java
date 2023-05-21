package com.spotify.objects.chapters;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import com.spotify.objects.audiobooks.SimplifiedAudiobook;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Chapter extends SimplifiedChapter implements SpotifyObject {


    //isplayable checl

    @SpotifyField
    private SimplifiedAudiobook audiobook;

}

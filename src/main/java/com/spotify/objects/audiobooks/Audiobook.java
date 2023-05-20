package com.spotify.objects.audiobooks;

import com.spotify.objects.SpotifyField;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Audiobook extends SimplifiedAudiobook {


    @SpotifyField
    private AudiobookChapter[] chapters;


}

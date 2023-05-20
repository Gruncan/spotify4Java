package com.spotify.objects.chapters;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ChapterResumePoint implements SpotifyObject {


    @SpotifyField("fully_played")
    private boolean fullyPlayed;

    @SpotifyField("resume_position_ms")
    private int resumePosition;

}

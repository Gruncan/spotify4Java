package com.spotify.objects.audiobooks;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import lombok.Setter;

@Setter
public class ChapterResumePoint implements SpotifyObject {

    @SpotifyField("fully_played")
    private boolean fullyPlayed;

    @SpotifyField("resume_position_ms")
    private int resumePosition;

}

package com.spotify.objects.audiobooks;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents a spotify audiobook author
 *
 * @see SimplifiedAudiobook
 * @see SpotifyObject
 */
@Getter
@Setter
public class AudiobookAuthor implements SpotifyObject {

    /**
     * The name of the author.
     */
    @SpotifyField
    private String name;

}


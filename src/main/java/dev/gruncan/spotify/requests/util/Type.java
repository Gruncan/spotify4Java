package dev.gruncan.spotify.requests.util;

import java.util.Locale;

public enum Type {

    ALBUM,
    ARTIST,
    PLAYLIST,
    TRACK,
    SHOW,
    EPISODE,
    AUDIOBOOK;


    @Override
    public String toString() {
        return super.name().toLowerCase(Locale.ROOT);
    }

}

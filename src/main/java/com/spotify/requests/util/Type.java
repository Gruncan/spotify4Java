package com.spotify.requests.util;

import java.util.Locale;

public enum Type {

    ARTIST,
    TRACK;


    @Override
    public String toString() {
        return super.name().toLowerCase(Locale.ROOT);
    }

}

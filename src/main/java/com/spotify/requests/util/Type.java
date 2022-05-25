package com.spotify.requests.util;

import java.util.Locale;

public enum Type {

    ARTISTS,
    TRACKS;


    @Override
    public String toString() {
        return super.name().toLowerCase(Locale.ROOT);
    }

}

package com.spotify.requests.util;

import java.util.Locale;

public enum Group {


    ALBUM,
    SINGLE,
    APPEARS_ON,
    COMPLICATION;

    @Override
    public String toString() {
        return this.name().toLowerCase(Locale.ROOT);
    }


}
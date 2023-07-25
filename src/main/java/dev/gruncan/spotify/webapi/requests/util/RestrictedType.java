package dev.gruncan.spotify.webapi.requests.util;

import java.util.Locale;

public enum RestrictedType {


    ARTISTS,
    TRACKS;


    @Override
    public String toString(){
        return super.name().toLowerCase(Locale.ROOT);
    }

}

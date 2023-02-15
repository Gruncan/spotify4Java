package com.spotify.objects;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface SpotifyField {

    // Since default can't be null, setting it to " is illegal json, therefore won't ever occur
    String value() default "\"";

    String[] path() default {};

}

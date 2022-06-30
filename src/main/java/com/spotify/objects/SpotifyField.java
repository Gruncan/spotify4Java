package com.spotify.objects;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface SpotifyField {

    String value();

    boolean required() default true;

    String[] path() default {};

}

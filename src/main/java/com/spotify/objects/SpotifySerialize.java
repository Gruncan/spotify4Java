package com.spotify.objects;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface SpotifySerialize {

    Class<? extends SpotifyObject> value();

    boolean isArray() default false;

}

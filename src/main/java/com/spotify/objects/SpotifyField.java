package com.spotify.objects;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface SpotifyField {

    String value();

    Class<?> type() default String.class;

    boolean isArray() default false;

    boolean required() default true;

    String[] path() default {};

}

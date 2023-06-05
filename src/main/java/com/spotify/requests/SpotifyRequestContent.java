package com.spotify.requests;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface SpotifyRequestContent {


    String value() default "\"";


    boolean isRaw() default false;

    String contentType() default "";

}

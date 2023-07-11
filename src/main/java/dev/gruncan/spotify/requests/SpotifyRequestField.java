package dev.gruncan.spotify.requests;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface SpotifyRequestField {

    String value() default "\"";

    boolean requireDefault() default false;

}

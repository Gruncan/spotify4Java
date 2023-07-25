package dev.gruncan.spotify.webapi.objects;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Represents a request that is to be serialized
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface SpotifySerialize {

    Class<? extends SpotifyObject> value();

    boolean isArray() default false;

}

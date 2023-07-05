package com.spotify.requests.util;


import lombok.Getter;

/**
 * Represents a spotify uri
 */
@Getter
public class SpotifyUriObject {

    /**
     * The uri of the object
     */
    private final String uri;

    /**
     * The id component of the uri
     */
    private final String id;

    /**
     * The type component of the uri
     */
    private final Type type;

    /**
     * Initializes the uri given a raw uri.
     * @param uri The raw uri string
     */
    public SpotifyUriObject(String uri){
        this.uri = uri;
        String[] split = uri.split(":");
        if (split.length != 3)
            throw new IllegalArgumentException("Failed to initialize, " +
                    "ensure spotify raw uri is of the format spotify:type:id");
        this.type = Type.valueOf(split[1]);
        this.id = split[2];
    }

    /**
     * Initializes the uri given a type and id
     * @param id the id of the uri
     * @param type the type of the uri
     */
    public SpotifyUriObject(String id, Type type){
        this.id = id;
        this.type = type;
        this.uri = String.format("spotify:%s:%s", this.type.toString(), this.id);
    }


    @Override
    public String toString() {
        return this.uri;
    }

}

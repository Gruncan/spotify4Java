package com.spotify;

import com.spotify.objects.SpotifyObject;
import com.spotify.objects.SpotifySerializer;
import com.spotify.requests.RequestResponse;

public class SpotifyResponse extends SpotifySerializer {


    private final RequestResponse requestResponse;
    private final Class<? extends SpotifyObject> cls;

    public SpotifyResponse(RequestResponse response, Class<? extends SpotifyObject> cls) {
        this.requestResponse = response;
        this.cls = cls;
    }

    public RequestResponse getRequestResponse() {
        return this.requestResponse;
    }

    @SuppressWarnings("unchecked")
    public <E extends SpotifyObject> E getSerialisedObject() {
        return (E) this.getSerialisedObject(this.cls);
    }

    private <E extends SpotifyObject> E getSerialisedObject(Class<E> cls) {
        return this.serializeObject(this.requestResponse.ok(), cls);
    }

}

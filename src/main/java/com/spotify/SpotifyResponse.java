package com.spotify;

import com.json.JSONArray;
import com.json.JSONObject;
import com.spotify.objects.SpotifyObject;
import com.spotify.objects.SpotifySerializer;
import com.spotify.requests.RequestResponse;

import java.lang.reflect.Array;

public class SpotifyResponse extends SpotifySerializer {


    private final RequestResponse requestResponse;
    private final Class<? extends SpotifyObject> cls;
    private String index = null;


    public SpotifyResponse(RequestResponse response, Class<? extends SpotifyObject> cls) {
        this.requestResponse = response;
        this.cls = cls;
    }

    public SpotifyResponse(RequestResponse response, Class<? extends SpotifyObject> cls, String index) {
        this(response, cls);
        this.index = index;

    }

    public RequestResponse getRequestResponse() {
        return this.requestResponse;
    }

    @SuppressWarnings("unchecked")
    public <E extends SpotifyObject> E[] getSerialisedObjects() {
        if (this.index == null) return null;
        JSONArray jsonArray = this.requestResponse.ok().getJSONArray(this.index);
        int length = jsonArray.length();
        E[] array = (E[]) Array.newInstance(this.cls, length);
        for (int i = 0; i < length; i++) {
            JSONObject json = jsonArray.getJSONObject(i);
            array[i] = (E) super.serializeObject(json, this.cls);
        }
        return array;
    }


    @SuppressWarnings("unchecked")
    public <E extends SpotifyObject> E getSerialisedObject() {
        return (E) super.serializeObject(this.requestResponse.ok(), cls);
    }

}

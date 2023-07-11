package dev.gruncan.spotify;

import dev.gruncan.json.JSONArray;
import dev.gruncan.json.JSONObject;
import dev.gruncan.spotify.objects.SpotifyObject;
import dev.gruncan.spotify.objects.SpotifySerializer;
import dev.gruncan.spotify.requests.RequestResponse;

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

    public JSONObject getJsonObject() {
        return this.requestResponse.getParsedJson();
    }

    public Class<? extends SpotifyObject> getRepresentedClass() {
        return this.cls;
    }

    public boolean wasSuccess() {
        return this.requestResponse.getCode() >= 200 || this.requestResponse.getCode() <= 203 ;
    }

    @SuppressWarnings("unchecked")
    public <E extends SpotifyObject> E[] getSerialisedObjects() {
        if (this.index == null) return null;
        JSONArray jsonArray = this.requestResponse.getParsedJson().getJSONArray(this.index);
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
        return (E) super.serializeObject(this.requestResponse.getParsedJson(), cls);
    }


}

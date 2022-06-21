package com.spotify.requests;

import com.spotify.json.JSONObject;

import java.io.Serializable;

public interface Serialize<T extends Serializable> {


    T serialize(JSONObject json);


}

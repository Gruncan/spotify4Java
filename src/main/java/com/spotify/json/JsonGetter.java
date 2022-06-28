package com.spotify.json;

public interface JsonGetter {


    <E> E get(Class<E> cls, String name, int index);

}

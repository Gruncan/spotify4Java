package com.spotify.requests;

import com.spotify.exceptions.SpotifySerializationException;
import com.spotify.json.JSONArray;
import com.spotify.json.JSONObject;
import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class SpotifySerializer {

    protected <E extends Serializable> E serializer(Class<E> cls, JSONObject json) {
        try {
            List<? super Serializable> parameters = new ArrayList<>();
            List<Class<? extends Serializable>> classes = new ArrayList<>();

            for (Field field : cls.getDeclaredFields()) {
                SpotifyField spotifyField = field.getAnnotation(SpotifyField.class);
                if (spotifyField == null) continue;


                Class<?> fieldRawType = field.getType();
                Class<? extends Serializable> fieldType;

                if (Serializable.class.isAssignableFrom(fieldRawType))
                    fieldType = (Class<? extends Serializable>) fieldRawType;
                else
                    continue;

                Class<? extends Serializable> type = (Class<? extends Serializable>) spotifyField.type();
                String name = spotifyField.value();
                JSONObject jsonPath = json;

                for (String p : spotifyField.path())
                    jsonPath = jsonPath.getJSONObject(p);


                if (!spotifyField.required() && jsonPath.isNull(name))
                    continue;
                else if (jsonPath.isNull(name))
                    throw new SpotifySerializationException(String.format("No mapping found for spotify required field: %s. " +
                            "Java variable: %s", spotifyField.value(), field.getName()));

                classes.add(fieldType);
                if (type.equals(String.class)) {
                    parameters.add(jsonPath.getString(name));
                } else if (type.equals(Integer.class)) {
                    parameters.add(jsonPath.getInt(name));
                } else if (type.equals(Boolean.class)) {
                    parameters.add(jsonPath.getBoolean(name));
                } else if (type.equals(Double.class)) {
                    parameters.add(jsonPath.getDouble(name));
                } else {
                    if (!SpotifyObject.class.isAssignableFrom(type)) continue;

                    if (fieldType.isArray()) {

                        JSONArray jsonArray = jsonPath.getJSONArray(name);
                        parameters.add(this.createArray(type, jsonArray));
                        // updates the last index with the correct type if its an array
                        //classes.set(classes.size() - 1, arrayType);
                    } else {
                        parameters.add(this.serializer(type, jsonPath.getJSONObject(name)));
                    }
                }
            }
            Constructor<?> ctor = cls.getConstructor(this.fromListToClassArray(classes));
            return (E) ctor.newInstance(parameters.toArray());
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException |
                 InvocationTargetException | SpotifySerializationException e) {
            e.printStackTrace();
            return null;
        }
    }

    private <E extends Serializable> E[] createArray(Class<E> cls, JSONArray jsonArray) {
        E[] array = (E[]) Array.newInstance(cls, jsonArray.length());
        for (int i = 0; i < array.length; i++) {
            array[i] = this.serializer(cls, jsonArray.getJSONObject(i));
        }
        return array;
    }

    private Class[] fromListToClassArray(List<Class<? extends Serializable>> list) {
        Class[] classes = new Class[list.size()];
        for (int i = 0; i < classes.length; i++) {
            classes[i] = list.get(i);
        }
        return classes;
    }


}

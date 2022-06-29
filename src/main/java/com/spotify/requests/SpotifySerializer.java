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

public class SpotifySerializer {


    protected <E extends Serializable> E serializer(Class<E> cls, JSONObject json) {
        try {
            Constructor<E> constructor = cls.getConstructor();
            E e = constructor.newInstance();

            for (Field field : cls.getDeclaredFields()) {
                SpotifyField spotifyField = field.getAnnotation(SpotifyField.class);
                // if not field not annotated continue
                if (spotifyField == null) continue;


                Class<?> fieldRawType = field.getType();
                Class<? extends Serializable> fieldType;

                // Casting field class to correctly subclass java.io.Serializable
                if (Serializable.class.isAssignableFrom(fieldRawType))
                    fieldType = (Class<? extends Serializable>) fieldRawType;
                else
                    continue;

                String name = spotifyField.value();

                // Get jsonobject if deeper in hierarchy
                JSONObject jsonPath = json;
                for (String p : spotifyField.path())
                    jsonPath = jsonPath.getJSONObject(p);


                //if field is not present and is required throw error can't serialize
                if (!spotifyField.required() && (jsonPath == null || jsonPath.isNull(name)))
                    continue;
                else if (jsonPath.isNull(name))
                    throw new SpotifySerializationException(String.format("No mapping found for spotify required field: %s. " +
                            "Java variable: %s", spotifyField.value(), field.getName()));


                field.setAccessible(true);

                if (fieldType.isArray()) {
                    Class<?> componentRawType = fieldType.getComponentType();
                    Class<? extends Serializable> componentType = (Class<? extends Serializable>) componentRawType;
                    if (!SpotifyObject.class.isAssignableFrom(componentType)) continue;

                    JSONArray jsonArray = jsonPath.getJSONArray(name);
                    field.set(e, this.createArray(componentType, jsonArray));
                } else {
                    field.set(e, this.serializeField(fieldType, jsonPath, name));
                }
                field.setAccessible(false);
            }
            return e;

        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException |
                 InvocationTargetException | SpotifySerializationException a) {
            a.printStackTrace();
            return null;
        }
    }

    private <E extends Serializable> E serializeField(Class<E> componentType, JSONObject jsonPath, String name) {
        if (!SpotifyObject.class.isAssignableFrom(componentType))
            return jsonPath.get(componentType, name);
        else
            return this.serializer(componentType, jsonPath.get(JSONObject.class, name));
    }


    private <E extends Serializable> E[] createArray(Class<E> cls, JSONArray jsonArray) {
        E[] array = (E[]) Array.newInstance(cls, jsonArray.length());
        for (int i = 0; i < array.length; i++)
            array[i] = this.serializeField(cls, jsonArray.getJSONObject(i), "value");
        return array;
    }
}

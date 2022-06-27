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
            // A list of parameters values to instantiate the json into an object
            List<? super Serializable> parameters = new ArrayList<>();
            // A list of classes of the types of which each parameter is
            List<Field> classes = new ArrayList<>();

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
                if (!spotifyField.required() && jsonPath.isNull(name))
                    continue;
                else if (jsonPath.isNull(name))
                    throw new SpotifySerializationException(String.format("No mapping found for spotify required field: %s. " +
                            "Java variable: %s", spotifyField.value(), field.getName()));


                field.setAccessible(true);

                classes.add(field);
                // 'primitive' serialization types
                if (fieldType.equals(String.class)) {
                    field.set(e, jsonPath.getString(name));
                } else if (fieldType.equals(Integer.class)) {
                    field.set(e, jsonPath.getInt(name));
                } else if (fieldType.equals(Boolean.class)) {
                    field.set(e, jsonPath.getBoolean(name));
                } else if (fieldType.equals(Double.class)) {
                    field.set(e, jsonPath.getDouble(name));
                } else {
                    Class<?> componentRawType = fieldType.getComponentType();

                    // Checks the none 'primitive' type extends com.spotify.objects.SpotifyObject
                    if (!SpotifyObject.class.isAssignableFrom(componentRawType)) continue;

                    if (fieldType.isArray()) {
                        Class<? extends Serializable> componentType = (Class<? extends Serializable>) componentRawType;

                        JSONArray jsonArray = jsonPath.getJSONArray(name);
                        // Add array of componentType, seperate method to allow casting of generic type
                        field.set(e, this.createArray(componentType, jsonArray));
                    } else {
                        // Continuely serialize objects into 'primitive' types
                        field.set(e, this.serializer(fieldType, jsonPath.getJSONObject(name)));
                    }
                }
                field.setAccessible(false);
            }

            return e;
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

    private Class<?>[] fromListToClassArray(List<Class<? extends Serializable>> list) {
        Class<?>[] classes = new Class[list.size()];
        for (int i = 0; i < classes.length; i++) {
            classes[i] = list.get(i);
        }
        return classes;
    }


}

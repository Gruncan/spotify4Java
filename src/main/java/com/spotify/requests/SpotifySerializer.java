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
            List<Class<? extends Serializable>> classes = new ArrayList<>();

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


                classes.add(fieldType);
                // 'primitive' serialization types
                if (fieldType.equals(String.class)) {
                    parameters.add(jsonPath.getString(name));
                } else if (fieldType.equals(Integer.class)) {
                    parameters.add(jsonPath.getInt(name));
                } else if (fieldType.equals(Boolean.class)) {
                    parameters.add(jsonPath.getBoolean(name));
                } else if (fieldType.equals(Double.class)) {
                    parameters.add(jsonPath.getDouble(name));
                } else {
                    Class<?> componentRawType = fieldType.getComponentType();

                    // Checks the none 'primitive' type extends com.spotify.objects.SpotifyObject
                    if (!SpotifyObject.class.isAssignableFrom(componentRawType)) continue;

                    if (fieldType.isArray()) {
                        Class<? extends Serializable> componentType = (Class<? extends Serializable>) componentRawType;

                        JSONArray jsonArray = jsonPath.getJSONArray(name);
                        // Add array of componentType, seperate method to allow casting of generic type
                        parameters.add(this.createArray(componentType, jsonArray));
                    } else {
                        // Continuely serialize objects into 'primitive' types
                        parameters.add(this.serializer(fieldType, jsonPath.getJSONObject(name)));
                    }
                }
            }
            // Convert list of class into array
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

package com.spotify.objects;

import com.json.JSONArray;
import com.json.JSONObject;
import com.spotify.exceptions.SpotifySerializationException;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class SpotifySerializer {


    /**
     * Recursively gets all fields from current class to highest in hierarchy
     */
    private List<Field> getAllFields(Class<?> cls){
        Class<?> supperCls = cls.getSuperclass();
        if (supperCls == null) return new ArrayList<>();

        List<Field> fields = this.getAllFields(supperCls);
        fields.addAll(Arrays.asList(cls.getDeclaredFields()));

        return fields;
    }


    @SuppressWarnings({"unchecked", "rawtypes"})
    private <E extends Serializable> E serializer(Class<E> cls, JSONObject json) throws SpotifySerializationException{
        try {
            if (cls.isEnum()) {
                return (E) this.handleEnum((Class<? extends Enum>) cls, json.getString("value"));
            }
            Constructor<E> constructor = cls.getConstructor();
            E e = constructor.newInstance();
            SpotifyOptional notRequiredCls = cls.getAnnotation(SpotifyOptional.class);

            boolean clsRequired = notRequiredCls != null;


            List<Field> allFields = this.getAllFields(cls);
            for (Field field : allFields) {

                SpotifyField spotifyField = field.getAnnotation(SpotifyField.class);
                // if not field not annotated ignore
                if (spotifyField == null) continue;

                SpotifyOptional spotifyNotRequired = field.getAnnotation(SpotifyOptional.class);

                boolean fieldRequired = spotifyNotRequired != null;


                boolean required = !(fieldRequired || clsRequired);

                Class<?> fieldRawType = field.getType();
                Class<? extends Serializable> fieldType;


                if (fieldRawType.isPrimitive()) {
                    if (fieldRawType.equals(int.class))
                        fieldRawType = Integer.class;
                    else if (fieldRawType.equals(boolean.class))
                        fieldRawType = Boolean.class;
                    else if (fieldRawType.equals(double.class))
                        fieldRawType = Double.class;
                    else
                        continue;
                }


                if (Serializable.class.isAssignableFrom(fieldRawType))
                    fieldType = (Class<? extends Serializable>) fieldRawType;
                else
                    continue;

                String name = spotifyField.value();
                if (name.equals("\""))
                    name = field.getName();


                // Get jsonobject if deeper in hierarchy
                JSONObject jsonPath = json;
                for (String p : spotifyField.path())
                    jsonPath = jsonPath.getJSONObject(p);


                //if field is not present and is required throw error can't serialize
                if (!required && (jsonPath == null || jsonPath.isNull(name)))
                    continue;
                else if (jsonPath == null || jsonPath.isNull(name))
                    throw new SpotifySerializationException(String.format("No mapping found for spotify required field: \"%s/%s\". " +
                            "Java class %s field: %s", String.join(".", spotifyField.path()), spotifyField.value(), cls, field.getName()));

                field.setAccessible(true);
                try {
                    if (fieldType.isArray()) {
                        Class<?> componentRawType = fieldType.getComponentType();
                        Class<? extends Serializable> componentType = (Class<? extends Serializable>) componentRawType;

                        JSONArray jsonArray = jsonPath.getJSONArray(name);
                        field.set(e, this.createArray(componentType, jsonArray));
                    } else {
                        field.set(e, this.serializeField(fieldType, jsonPath, name));
                    }
                    field.setAccessible(false);
                }catch (SpotifySerializationException a){
                    if(spotifyField.canSkip()) continue;
                    a.printStackTrace();
                    return null;
                }
            }
            return e;

        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException |
                 InvocationTargetException a) {
            a.printStackTrace();
            return null;
        }
    }

    private <E extends Serializable> E serializeField(Class<E> componentType, JSONObject jsonPath, String name) throws SpotifySerializationException {
        if (!SpotifyObject.class.isAssignableFrom(componentType))
            return jsonPath.get(componentType, name);
        else {
            JSONObject jsonv = jsonPath.get(JSONObject.class, name);
            if (jsonv == null) {
                return this.serializer(componentType, jsonPath);
            } else {
                return this.serializer(componentType, jsonPath.get(JSONObject.class, name));
            }
        }
    }

    @SuppressWarnings("unchecked")
    private <E extends Serializable> E[] createArray(Class<E> cls, JSONArray jsonArray) throws SpotifySerializationException {
        E[] array = (E[]) Array.newInstance(cls, jsonArray.length());
        for (int i = 0; i < array.length; i++)
            array[i] = this.serializeField(cls, jsonArray.getModifiedJSONObject(i), "value");
        return array;
    }

    private <E extends Enum<E>> E handleEnum(Class<E> cls, String value) {
        return Enum.valueOf(cls, value);
    }

    protected <S extends SpotifyObject> S serializeObject(JSONObject json, Class<S> cls) {
        if (json == null || cls == null) return null;
        try{
            return this.serializer(cls, json);
        }catch (SpotifySerializationException e){
            e.printStackTrace();
            return null;
        }

    }
}
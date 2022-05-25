package com.spotify.requests.util;

public class ParameterPairBuilder {


    private String[] keys;
    private Class<?>[] classes;


    public ParameterPairBuilder addKeys(String... keys) {
        this.keys = keys;
        return this;
    }

    public ParameterPairBuilder addClasses(Class<?>... classes) {
        this.classes = classes;
        return this;
    }


    public ParameterPair[] build() {
        if (this.keys.length != this.classes.length) return null;
        ParameterPair[] parameterPairs = new ParameterPair[this.keys.length];
        for (int i = 0; i < parameterPairs.length; i++) {
            parameterPairs[i] = new ParameterPair(this.keys[i], this.classes[i]);
        }

        return parameterPairs;

    }


}

package com.spotify.requests;

/**
 * Represents a HTTP Request Query parameter (key value pair) in the form <url>?key1=value1&key2=value2
 *
 * @param <T> The type of the value, must have {@code toString()}
 */
public class RequestQuery<T> {

    private final String key;
    private final T value;

    /**
     *
     * @param key The key of the query parameter
     * @param value The value of the query parameter
     */
    public RequestQuery(String key, T value) {
        this.key = key;
        this.value = value;
    }


    /**
     * Gets the formatter key value pair
     * @return {@code String} in the format of key=value
     */
    public String getPair() {
        return String.format("%s=%s", this.key, this.value.toString());
    }

    /**
     * Gets the key of the key value pair
     * @return {@code String} the key
     */
    public String getKey() {
        return this.key;
    }

    @Deprecated
    public Class<?> getQueryType() {
        return this.value.getClass();
    }


}

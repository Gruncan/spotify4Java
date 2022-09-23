package com.spotify.util;

public class Util {


    public static String join(String[] strings, String deliminator) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            sb.append(strings[i]);
            if (i != strings.length - 1)
                sb.append(deliminator);
        }
        return sb.toString();
    }
}

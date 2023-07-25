package dev.gruncan.spotify.util;

import java.util.HashMap;
import java.util.Map;

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


    public static Map<String, String> queryToMap(String query) {
        if (query == null) {
            return null;
        }
        Map<String, String> result = new HashMap<>();
        for (String param : query.split("&")) {
            String[] entry = param.split("=");
            if (entry.length > 1) {
                result.put(entry[0], entry[1]);
            } else {
                result.put(entry[0], "");
            }
        }
        return result;
    }

    public static String mapToQuery(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        sb.append("?");
        for (Map.Entry<String, String> pair : map.entrySet()) {
            String key = pair.getKey();
            String value = pair.getValue();
            sb.append(key).append("=").append(value).append("&");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

}

package com.spotify.requests.data;

import com.json.JSONArray;
import com.json.JSONObject;
import com.spotify.SpotifyClient;
import com.spotify.SpotifyResponse;
import com.spotify.requests.SpotifyClientTester;
import com.spotify.requests.SpotifyRequestExecutor;
import com.spotify.requests.SpotifyRequestVariant;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Designed to be run once before release to checked data is correct.
 * Runs all requests writes built url and response json to file
 */
public class RetrieveSpotifyData {


    private static final String LOCATION = "src/test/java/com/spotify/requests/data/";
    private static final String VERSION = "V1_0_0";

    public static void main(String[] args) throws ClassNotFoundException {
        String fileContents = getFileContents();
        if (fileContents == null) return;
        Map<String, SpotifyResponse> responses = getResponses(fileContents);
        writeResults(responses);
    }

    private static void writeResults(Map<String, SpotifyResponse> responses) {
        try {

            String filename = String.format("SpotifyResponses-%s.json", VERSION);
            File file = new File(LOCATION + filename);

            if (!file.createNewFile()) {
                if (!file.delete()) return;
                if (!file.createNewFile()) return;
            }

            try (FileWriter writer = new FileWriter(LOCATION + filename)) {
                writer.write("{");
                int i = 0;
                for (Map.Entry<String, SpotifyResponse> pair : responses.entrySet()) {
                    writer.write("\"" + pair.getKey() + "\": {");
                    writer.write("\"json\": " + pair.getValue().getJsonObject());
                    writer.write(", \"cls\": \"" + pair.getValue().getRepresentedClass() + "\"");
                    writer.write("}");
                    if (i != responses.size() - 1) writer.write(",\n");
                    i++;
                }

                writer.write("}");
            }
            System.out.printf("\nSuccessfully wrote results to file: %s%n", filename);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static Map<String, SpotifyResponse> getResponses(String fileContents) throws ClassNotFoundException {
        Map<String, SpotifyResponse> responses = new HashMap<>();
        JSONObject json = new JSONObject(fileContents);
        for (String key : json.keySet()) {
            Class<? extends SpotifyRequestVariant> cls = (Class<? extends SpotifyRequestVariant>) Class.forName(key);
            JSONObject inner = json.getJSONObject(key);

            Object[] params = inner.keySet().stream()
                    .filter(s -> !s.equals("url"))
                    .map(s -> {
                        JSONArray array = inner.getJSONArray(s);
                        if (array != null)
                            return array.getValues().toArray();
                        else
                            return inner.get(s);
                    })
                    .toArray();

            for (int i = 0; i < params.length; i++) {
                if (params[i].getClass().isArray()) {
                    params[i] = getStringArray((Object[]) params[i]);
                }
            }
            Pair<String, SpotifyResponse> responsePair = execute(cls, params);
            if (responsePair == null) continue;
            responses.put(responsePair.key(), responsePair.value());
        }
        return responses;
    }

    private static <T extends SpotifyRequestVariant> Pair<String, SpotifyResponse> execute(Class<T> cls, Object... params) {
        try {
            Constructor<T> con = (Constructor<T>) cls.getConstructors()[0];
            T request = con.newInstance(params);
            SpotifyRequestExecutor sc = SpotifyClientTester.getSpotifyClient();
            System.out.printf("Executed %s%n", cls.getName());
            SpotifyResponse response = ((SpotifyClient) sc).executeRequest(request);
            String url = sc.getCachedURL();
            return new Pair<>(url, response);

        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;

    }

    private static String getFileContents() {
        String file = LOCATION + "requestUrlClasses.json";
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            return reader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String[] getStringArray(Object[] o) {
        String[] s = new String[o.length];
        for (int i = 0; i < s.length; i++) {
            s[i] = (String) o[i];
        }
        return s;
    }

    private record Pair<K, V>(K key, V value) {
    }
}

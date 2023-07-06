package dev.gruncan.spotify.requests.data;

import dev.gruncan.json.JSONArray;
import dev.gruncan.json.JSONObject;
import dev.gruncan.spotify.SpotifyClient;
import dev.gruncan.spotify.SpotifyResponse;
import dev.gruncan.spotify.requests.SpotifyClientTester;
import dev.gruncan.spotify.requests.SpotifyRequestExecutor;
import dev.gruncan.spotify.requests.SpotifyRequestVariant;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * Designed to be run once before release to checked data is correct.
 * Runs all requests writes built url and response json to file
 */
public class RetrieveSpotifyData {


    private static final String LOCATION = "src/test/java/dev/gruncan/spotify/requests/data/resources/";
    private static final String VERSION = "V1_5_0";

    public static void main(String[] args) throws ClassNotFoundException {
        String fileContents = Util.getFileContents(LOCATION + "requestUrlClasses-V1_5_0.json");
        if (fileContents == null) return;
        Map<Class<? extends SpotifyRequestVariant>, Pair> responses = getResponses(fileContents);
        writeResults(responses);
    }

    private static void writeResults(Map<Class<? extends SpotifyRequestVariant>, Pair> responses) {
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
                for (Map.Entry<Class<? extends SpotifyRequestVariant>, Pair> pair : responses.entrySet()) {
                    writer.write("\"" + pair.getKey() + "\": {");
                    writer.write("\"json\": " + pair.getValue().response().getJsonObject());
                    writer.write(", \"cls\": \"" + pair.getValue().response().getRepresentedClass() + "\"");
                    writer.write(", \"url\": \"" + pair.getValue().url() + "\"");
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

    private static Map<Class<? extends SpotifyRequestVariant>, Pair> getResponses(String fileContents) throws ClassNotFoundException {
        Map<Class<? extends SpotifyRequestVariant>, Pair> responses = new HashMap<>();
        JSONObject json = new JSONObject(fileContents);
        int length = json.keySet().size();
        int c = 1;
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
            Tuple<? extends SpotifyRequestVariant> responseTuple = execute(cls, params);
            if (responseTuple == null) continue;
            System.out.printf("%d/%d | Executed %s%n", c, length, cls.getName());
            responses.put(responseTuple.request(), new Pair(responseTuple.url, responseTuple.response()));
            c++;
        }
        return responses;
    }

    private static <T extends SpotifyRequestVariant> Tuple<T> execute(Class<T> cls, Object... params) {
        try {
            Constructor<T> con = (Constructor<T>) cls.getConstructors()[0];
            T request = con.newInstance(params);
            SpotifyRequestExecutor sc = SpotifyClientTester.getSpotifyClient();

            SpotifyResponse response = ((SpotifyClient) sc).executeRequest(request);
            String url = sc.getCachedURL();
            return new Tuple<>(cls, url, response);

        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
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

    private record Tuple<T extends SpotifyRequestVariant>(Class<T> request, String url, SpotifyResponse response) {
    }

    private record Pair(String url, SpotifyResponse response) {

    }
}

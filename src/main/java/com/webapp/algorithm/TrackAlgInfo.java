package com.webapp.algorithm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TrackAlgInfo {


    private final String id;
    private final double score;


    public TrackAlgInfo(String id, double score) {
        this.id = id;
        this.score = score;
    }

    public static List<TrackAlgInfo> loadFromFile(String filename) {
        File file = new File(filename);
        List<String> lines = new ArrayList<>();
        List<TrackAlgInfo> list = new ArrayList<>();
        try {
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                lines.add(data);
            }
            reader.close();

            for (String line : lines) {
                String[] data = line.split(",");
                if (data.length == 2) {
                    list.add(new TrackAlgInfo(data[0], Double.parseDouble(data[1])));
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }

        return list;
    }

    public String getId() {
        return this.id;
    }

    public double getScore() {
        return this.score;
    }


}

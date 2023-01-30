package com.spotify.requests.tracks;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TrackRecommendationGetTest {


    @Test
    public void setMaximums() throws NoSuchFieldException, IllegalAccessException {

        String[] arr = new String[6];
        TrackRecommendationGet trg = new TrackRecommendationGet(arr, arr, arr);

        double[] values = new double[]{10d, 10d, 10d, 10d, 10d, 10d, 10d, 10d, 10d, 10d, 10d, 10d, 10d, 10d};
        trg.setMaximums(values);

        Field timeSig = trg.getClass().getDeclaredField("max_time_signature");
        timeSig.setAccessible(true);
        Object timeSigO = timeSig.get(trg);
        assertEquals(10, (int) timeSigO);

    }


    @Test
    public void setMinimums() throws NoSuchFieldException, IllegalAccessException {

        String[] arr = new String[6];
        TrackRecommendationGet trg = new TrackRecommendationGet(arr, arr, arr);

        double[] values = new double[]{-10d, -10d, -10d, -10d, -10d, -10d, -10d, -10d, -10d, -10d, -10d, -10d, -10d, -10d};
        trg.setMinimums(values);

        Field timeSig = trg.getClass().getDeclaredField("min_time_signature");
        timeSig.setAccessible(true);
        Object timeSigO = timeSig.get(trg);
        assertEquals(-10, (int) timeSigO);

    }

    @Test
    public void setTargets() throws NoSuchFieldException, IllegalAccessException {

        String[] arr = new String[6];
        TrackRecommendationGet trg = new TrackRecommendationGet(arr, arr, arr);

        double[] values = new double[]{5d, 5d, 5d, 5d, 5d, 5d, 5d, 5d, 5d, 5d, 5d, 5d, 5d, 5d};
        trg.setTargets(values);

        Field timeSig = trg.getClass().getDeclaredField("target_time_signature");
        timeSig.setAccessible(true);
        Object timeSigO = timeSig.get(trg);
        assertEquals(5, (int) timeSigO);

    }


}
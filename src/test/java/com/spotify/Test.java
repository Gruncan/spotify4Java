package com.spotify;

public class Test {


    public static void main(String[] args) {
        int[] array = new int[10];

        Class<?> cls = array.getClass();

        Class<?> comp = cls.getComponentType();
        System.out.println(cls);
        System.out.println(comp);

        System.out.println(Double[].class);

    }

}

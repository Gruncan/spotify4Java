package com.webapp.algorithm;

import java.lang.reflect.Field;

public class Main {


    private boolean test;


    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Main main = new Main();
        Field field = Main.class.getDeclaredField("test");
        field.setAccessible(true);
        Boolean b = Boolean.TRUE;
        System.out.println(b.getClass());
        field.set(main, b);

        System.out.println(main.test);


    }


}

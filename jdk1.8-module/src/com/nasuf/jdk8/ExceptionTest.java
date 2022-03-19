package com.nasuf.jdk8;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionTest {

    public void throwZero(int i) {
        if ( i == 0 ) {
            throw new RuntimeException("arg is zero.");
        }
    }

    public void throwOne(int i) throws RuntimeException, IOException {
        if ( i == 1 ) {
            throw new RuntimeException("arg is one.");
        }
    }

    public void throwArithmatic() {
        int i = 10;
        int j = i/0;
        System.out.println(j);
    }

    public void tryCatch() {
        try {
            File file = new File("/d/file");
            FileInputStream fis = new FileInputStream(file);
            String info = "nasuf";
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    public static String func() {
        String str = "hello";
        try {
            return str;
        } finally {
            str = "world";
        }
    }



}

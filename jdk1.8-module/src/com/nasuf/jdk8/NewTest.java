package com.nasuf.jdk8;

import java.io.File;

public class NewTest {
    public void newInstance() {
        Object obj = new Object();
        File file = new File("1.txt");
    }

    public void newArray() {
        int[] intArray = new int[10];
        Object[] objArray = new Object[10];
        int[][] mintArray = new int[10][10];
        String[][] strArray = new String[10][];
    }

    public void sayHello() {
        System.out.println("hello");
    }

    public void setOrderId() {
        Order order =  new Order();
        order.id = 1001;
        System.out.println(order.id);

        Order.name = "ORDER";
        System.out.println(Order.name);
    }

    public void setArray() {
        int[] intArray = new int[10];
        intArray[3] = 20;
        System.out.println(intArray[1]);
    }

    public void arrLength() {
        double[] arr = new double[10];
        System.out.println(arr.length);
    }

    public String checkCast(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        } else {
            return null;
        }
    }
}

class Order {
    int id;
    static String name;
}
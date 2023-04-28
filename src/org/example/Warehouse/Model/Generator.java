package org.example.Warehouse.Model;

import java.util.Random;

public class Generator {
    static Random r = new Random();

    public static int number(int left, int right) {
        return r.nextInt(left, right);
    }
}

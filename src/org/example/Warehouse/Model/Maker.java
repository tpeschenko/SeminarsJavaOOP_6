package org.example.Warehouse.Model;

import java.util.ArrayList;
import java.util.List;

public class Maker{
    private static List<Company> makerlist = new ArrayList<>();

    public Maker(List<Company> list) {
        makerlist = list;
    }

    public static void add(Company company) {
        makerlist.add(company);
    }

    public static boolean remove(Company company) {
        return makerlist.remove(company);
    }
}

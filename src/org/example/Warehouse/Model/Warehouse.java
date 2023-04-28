package org.example.Warehouse.Model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;


public class Warehouse extends Nomenclature {
    private static List<Product> productList; //= new ArrayList<>();

    public Warehouse(String name, List<Product> list) {
        super(name);
        productList = list;
    }

    public void append(Product product) {
        productList.add(product);
    }

    public boolean delete(Product product) {
        return productList.remove(product);
    }

    public List<Product> getProductList() {
        return productList;
    }
}

package org.example.Warehouse.Service;

import org.example.Warehouse.Model.Product;

public interface Processable {
    boolean processOrder(Product product, int amount);
}

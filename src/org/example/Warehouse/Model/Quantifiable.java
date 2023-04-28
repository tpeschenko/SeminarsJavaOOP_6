package org.example.Warehouse.Model;

public interface Quantifiable {
    boolean decreaseQuantity(int amount);
    void increaseQuantity(int amount);
}

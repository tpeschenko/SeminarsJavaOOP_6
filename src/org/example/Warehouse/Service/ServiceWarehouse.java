package org.example.Warehouse.Service;

import lombok.Data;
import org.example.Warehouse.Model.Product;
import org.example.Warehouse.Model.Warehouse;

import java.util.List;

@Data
public class ServiceWarehouse implements Processable {

    public Warehouse create(String name, List<Product> list) {
        return new Warehouse(name, list);
    }

    public void append(Warehouse warehouse, Product product) {
        warehouse.append(product);
    }

    public boolean delete(Warehouse warehouse, Product product) {
        return warehouse.delete(product);
    }

    @Override
    public boolean processOrder(Product product, int amount) {
        if (amount > 0) {
            product.increaseQuantity(amount);
            return true;
        } else {
            return product.decreaseQuantity(-amount);
        }
    }
}

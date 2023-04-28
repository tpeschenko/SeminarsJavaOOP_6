package org.example.Warehouse.Service;

import lombok.NoArgsConstructor;
import org.example.Warehouse.Model.*;

import java.util.List;

@NoArgsConstructor
public class ServiceOrder implements Processable {

    public OrderList create(Warehouse warehouse, List<Order> list) {
        return new OrderList(warehouse, list);
    }

    @Override
    public boolean processOrder(Product product, int amount) {
        if (amount > 0) {
            return product.decreaseQuantity(amount);
        } else {
            System.out.println("The quantity of the product must be greater than zero");
            return false;
        }
    }

    public List<Order> goodsRelease(List<Order> orderList) {
        for(Order o: orderList) {
            if (!o.getStatus().equals(OrderStatus.PROCESSED)) {
                Product p = o.getProduct();
                if (processOrder(p, o.getAmount())) {
                    o.setStatus(OrderStatus.PROCESSED);
                } else {
                    o.setStatus(OrderStatus.PAUSED);
                }
            }
        }
        return orderList;
    }
}

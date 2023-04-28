package org.example.Warehouse.Model;

import java.util.List;

public class OrderList{

    private Warehouse warehouse;
    private List<Order> orderList; // = new ArrayList<>();

    public OrderList(Warehouse warehouse, List<Order> list) {
        this.warehouse = warehouse;
        this.orderList = list;
    }

    public void add(Order order) {
        orderList.add(order);
    }
}

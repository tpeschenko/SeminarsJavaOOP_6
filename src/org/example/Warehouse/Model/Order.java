package org.example.Warehouse.Model;

import java.time.LocalDate;

public class Order {
    private static int count;
    private int number;
    private LocalDate date;
    private OrderStatus status;
    private Product product;
    private int amount;

    public Order(LocalDate date, Product product, int amount) {
        this.number = ++count;
        this.date = date;
        this.status = OrderStatus.PLACED;
        this.product = product;
        this.amount = amount;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        return sb.append(status).append(" ")
                .append(number).append(" ")
                .append(date).append(" ")
                .append(product.info()).append(" x ")
                .append(amount).append(" ")
                .append(product.getMeasurement()).append(" = ")
                .append(amount*product.getPrice())
                .toString();
    }

    public Product getProduct() {
        return product;
    }

    public int getAmount() {
        return amount;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public OrderStatus getStatus() {
        return status;
    }
}

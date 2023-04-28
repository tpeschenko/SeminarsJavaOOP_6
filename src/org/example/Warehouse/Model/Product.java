package org.example.Warehouse.Model;

public class Product extends Nomenclature implements Quantifiable {
    private int amount;
    private String measurement;
    private double price;
    private Company maker;

    public Product(String name, int amount, String measurement, double price, Company maker) {
        super(name);
        this.amount = amount;
        this.measurement = measurement;
        this.price = price;
        this.maker = maker;
    }

    @Override
    public boolean decreaseQuantity(int amount) {
        if (this.amount >= amount) {
            this.amount -= amount;
            return true;
        } else {
            System.out.printf("Cannot be processed by %d: available in %d %s\n\n", amount, this.amount, this.measurement);
            return false;
        }
    }

    @Override
    public void increaseQuantity(int amount) {
        this.amount += amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return this.id == product.id || super.name == product.name
                && this.price == product.price  && this.maker == product.maker;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        return sb
                .append(id).append(" ")
                .append(name).append(" ")
                .append(info()).append(" ")
                .append(amount).append(" = ")
                .append(amount*price)
                .toString();
    }

    public String info() {
        StringBuilder sb = new StringBuilder();
        return sb.append(name).append(" (")
                .append(maker.name).append(") ")
                .append(price)
                .toString();
    }

    public int getAmount() {
        return amount;
    }

    public String getMeasurement() {
        return measurement;
    }

    public double getPrice() {
        return price;
    }
}

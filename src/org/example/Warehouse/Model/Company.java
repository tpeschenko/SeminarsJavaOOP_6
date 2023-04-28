package org.example.Warehouse.Model;

public class Company extends Nomenclature{

    private String address;
    private String paymentAccount;

    public Company(String name, String address, String paymentAccount) {
        super(name);
        this.address = address;
        this.paymentAccount = paymentAccount;
    }

    @Override
    public String toString() {
        return "(Produced by: " + name + ", adress: " + address + ", payment account: " + paymentAccount + ')';
    }
}

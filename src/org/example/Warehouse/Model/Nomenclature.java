package org.example.Warehouse.Model;

public class Nomenclature{
    protected int id;
    protected String name;

    public Nomenclature(String name) {
        this.id = Index.createId();
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

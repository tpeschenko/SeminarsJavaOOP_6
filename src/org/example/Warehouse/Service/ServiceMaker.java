package org.example.Warehouse.Service;

import org.example.Warehouse.Model.Company;
import org.example.Warehouse.Model.Maker;

import java.util.List;

public class ServiceMaker {

    public List<Company> create(List<Company> list) {
        return (List<Company>) new Maker(list);
    }

    public void add(Company company){
        Maker.add(company);
    }

    public void delete(Company company) {
        if (!Maker.remove(company)) System.out.println("Unknown maker " + company.getName());
    }
}

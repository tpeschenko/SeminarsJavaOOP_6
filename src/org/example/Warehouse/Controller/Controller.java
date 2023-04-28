package org.example.Warehouse.Controller;

import org.example.Warehouse.Model.*;
import org.example.Warehouse.Service.ServiceMaker;
import org.example.Warehouse.Service.ServiceOrder;
import org.example.Warehouse.Service.ServiceWarehouse;
import org.example.Warehouse.View;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    public Controller() {

        List<Company> makers = new ArrayList<>();
        for (int i = 1; i < 3; i++) {
            makers.add(new Company("Maker#" + i, "Address#" + i,""));
        }
        ServiceMaker serviceC = new ServiceMaker();

        List<Product> products = new ArrayList<>();
        for (int i = 1; i < 3; i++) {
            products.add(new Product("Product#"+i
                    , Generator.number(1,10) * 10
                    , "pieces"
                    , Generator.number(1,10) * 10
                    , makers.get(i%2)));
        }

        ServiceWarehouse serviceWarehouse = new ServiceWarehouse();
        Warehouse warehouse = serviceWarehouse.create("Wirehouse#1", products);

        View view = new View();
        System.out.println("Начальные остатки на складе " + warehouse.getName() +"\n" + view.viewAll(products));

        for (int i = 3; i < 7; i++) {
            warehouse.append(new Product("Product#"+i
                    , Generator.number(1,10) * 10
                    , "pieces"
                    , Generator.number(1,10) * 10
                    , makers.get(i%2)));
        }
        System.out.println("Добавление позиций. Отатки на складе "
                + warehouse.getName() +"\n" + view.viewAll(products));

        warehouse.delete(products.get(0));
        warehouse.delete(products.get(0));

        System.out.println("Удаление позиций. Отатки на складе "
                + warehouse.getName() +"\n" + view.viewAll(products));

        products.forEach(n -> n.increaseQuantity(20));
        System.out.println("Увеличение количества товара. Отатки на складе "
                + warehouse.getName() +"\n" + view.viewAll(products));

        products.forEach(n -> n.decreaseQuantity(10));
        System.out.println("Уменьшение количества товара. Отатки на складе "
                + warehouse.getName() +"\n" + view.viewAll(products));

        List<Order> orders = new ArrayList<>();

        for (int i = 0; i <products.size() ; i++) {
            orders.add(new Order(
                            LocalDate.now()
                            , products.get(i)
                            , Generator.number(1, 10) * 10)
                        );
        }

        ServiceOrder serviceOrder = new ServiceOrder();
        serviceOrder.create(warehouse, orders);

        System.out.println("Заказы сформированы (" + warehouse.getName() + ")\n"
                + view.viewAll(orders));

        System.out.println("Заказы обработаны ( " + warehouse.getName() +")\n"
                + view.viewAll(serviceOrder.goodsRelease(orders)));

        System.out.println("Конечные остатки на складе " + warehouse.getName() +"\n" + view.viewAll(products));
    }
}

package org.example.service;

import org.example.model.Material;
import org.example.model.Warehouse;
import org.example.model.WarehousesManager;
import org.example.utility.WarehouseInterface;
import org.example.validators.Validators;

import java.util.List;
import java.util.Map;

public class WarehouseService implements WarehouseInterface {

    @Override
    public void addWarehouse(WarehousesManager warehousesManager, Warehouse warehouse) {
        if (Validators.isExistWarehouse(warehousesManager, warehouse)) {
            System.out.println("\\u001B[31m"+"The Warehouse " + warehouse.getName() + " is already exist");
        } else {
            warehousesManager.getWarehouses().add(warehouse);
            System.out.println("The Warehouse " + warehouse.getName() + " is added ☑\uFE0F");
        }
    }

    @Override
    public void showWarehousesList(WarehousesManager warehousesManager) {
        List<Warehouse> warehouses = warehousesManager.getWarehouses();
        int index = 1;
        if (warehouses.isEmpty()) {
            System.out.println("The List of Warehouses is empty you can create new ! ");
        } else {
            System.out.println("\nWarehouses");
            System.out.println("____________________");
            for (Warehouse x : warehouses) {
                System.out.println(index + " , " + x.getName());
                index++;
            }
            System.out.println("____________________");
        }
    }

    @Override
    public void showWarehousesListWithoutSelectedWarehouse(WarehousesManager warehousesManager, Warehouse warehouse) {
        List<Warehouse> warehouses = warehousesManager.getWarehouses();
        int index = 1;
        System.out.println("Warehouses");
        System.out.println("____________________");
        for (Warehouse x : warehouses) {
            if (x.equals(warehouse)){
                index++;
                continue;
            }
            System.out.println(index + " , " + x.getName());
            index++;
        }
        System.out.println("____________________");


    }

    @Override
    public Warehouse getWarehouse(WarehousesManager warehousesManager, int index) {
        return warehousesManager.getWarehouses().get(index);
    }

}



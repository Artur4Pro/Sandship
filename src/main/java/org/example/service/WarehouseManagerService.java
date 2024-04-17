package org.example.service;

import org.example.model.Warehouse;
import org.example.model.WarehousesManager;
import org.example.utility.WareHousesManagerInterface;
import org.example.validators.Validators;

public class WarehouseManagerService implements WareHousesManagerInterface {
    @Override
    public void addWarehouse(WarehousesManager warehousesManager, Warehouse warehouse) {
        if (Validators.isExistWarehouse(warehousesManager, warehouse)){
            System.out.println("The Warehouse " + warehouse.getName() + " is already exist");
        }else {
            warehousesManager.getWarehouses().add(warehouse);
            System.out.println("The Warehouse " + warehouse.getName() + "is added");
        }
    }
}

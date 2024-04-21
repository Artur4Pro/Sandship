package org.example.controller;

import org.example.model.Warehouse;
import org.example.model.WarehouseCollection;
import org.example.service.Impl.WarehouseCollectionService;

public class WarehouseCollectionController {

    private final WarehouseCollectionService warehouseCollectionService = new WarehouseCollectionService();

    /**
     * Adds the specified warehouse to the warehouse collection.
     *
     * <p>This method delegates the addition of the warehouse to the warehouse collection service.
     * If any exception occurs during the process, it prints the error message to the console.
     **/
    public void addWarehouse(WarehouseCollection warehouseCollection, Warehouse warehouse) {
        try {
            warehouseCollectionService.addWarehouse(warehouseCollection, warehouse);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Displays the list of warehouses in the provided warehouse collection.
     *
     * <p>This method delegates the display of warehouses to the warehouse collection service.
     * If any exception occurs during the process, it prints the error message to the console.
     **/
    public void showWarehousesList(WarehouseCollection warehouseCollection) {
        try {
            warehouseCollectionService.showWarehousesList(warehouseCollection);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

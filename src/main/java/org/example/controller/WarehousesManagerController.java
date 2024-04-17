package org.example.controller;

import org.example.model.Warehouse;
import org.example.model.WarehousesManager;
import org.example.service.WarehouseManagerService;

public class WarehousesManagerController {
    private final WarehouseManagerService warehouseManagerService = new WarehouseManagerService();

    public void addWarehouse(WarehousesManager warehousesManager, Warehouse warehouse) {
        warehouseManagerService.addWarehouse(warehousesManager, warehouse);
    }

}

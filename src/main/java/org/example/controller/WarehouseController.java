package org.example.controller;

import org.example.model.Material;
import org.example.model.Warehouse;
import org.example.model.WarehousesManager;
import org.example.service.WarehouseService;

import java.util.List;
import java.util.Map;

public class WarehouseController {
    private final WarehouseService warehouseService = new WarehouseService();

    public void addWarehouse(WarehousesManager warehousesManager, Warehouse warehouse) {
        warehouseService.addWarehouse(warehousesManager, warehouse);
    }

    public void showWarehousesList(WarehousesManager warehousesManager) {
        warehouseService.showWarehousesList(warehousesManager);
    }

    public Warehouse getWarehouse(WarehousesManager warehousesManager, int index) {
        return warehouseService.getWarehouse(warehousesManager, index);
    }

    public void showWarehousesListWithoutSelectedWarehouse(WarehousesManager warehousesManager, Warehouse warehouse) {
        warehouseService.showWarehousesListWithoutSelectedWarehouse(warehousesManager,warehouse);
    }

}

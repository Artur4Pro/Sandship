package org.example.controller;

import org.example.model.Material;
import org.example.model.Warehouse;
import org.example.model.WarehousesManager;
import org.example.service.WarehouseService;

import java.util.Map;

public class WarehouseController {
    private final WarehouseService warehouseService = new WarehouseService();

    public void addMaterial(Map<Material, Integer> materials, Material material, int quantity) {
        warehouseService.addMaterial(materials, material, quantity);
    }

    public void removeMaterial(Map<Material, Integer> materials, Material material) {
        warehouseService.removeMaterial(materials, material);
    }

    public int getMaterialQuantity(Map<Material, Integer> materials, Material material) {
        return warehouseService.getMaterialQuantity(materials, material);
    }

    public void getWarehouseMaterials(Map<Material, Integer> materials) {
        warehouseService.getWarehouseMaterials(materials);
    }

    public void moveMaterial(WarehousesManager warehousesManager, Warehouse warehouseFrom, Warehouse warehouseTo, Material material, int quantity) {
        warehouseService.moveMaterial(warehousesManager, warehouseFrom, warehouseTo, material, quantity);
    }

}

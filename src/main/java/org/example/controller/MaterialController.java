package org.example.controller;

import org.example.model.Material;
import org.example.model.MaterialType;
import org.example.model.Warehouse;
import org.example.model.WarehousesManager;
import org.example.service.MaterialService;

import java.util.Map;

public class MaterialController {
    private final MaterialService materialService = new MaterialService();

    public Material newMaterial(MaterialType materialType, String description, String icon, int maxCapacity) {
        return materialService.newMaterial(materialType, description, icon, maxCapacity);
    }
    public boolean addMaterial(Warehouse warehouse, Material material, int quantity) {
        return materialService.addMaterial(warehouse, material, quantity);
    }

    public boolean removeMaterial(Warehouse warehouse, Material material) {
        return materialService.removeMaterial(warehouse, material);
    }

    public int getMaterialQuantity(Warehouse warehouse, Material material) {
        return materialService.getMaterialQuantity(warehouse, material);
    }

    public void getWarehouseMaterials(Warehouse warehouse) {
        materialService.getWarehouseMaterials(warehouse);
    }

    public boolean moveMaterial(WarehousesManager warehousesManager, Warehouse warehouseFrom, Warehouse warehouseTo, Material material, int quantity) {
        return materialService.moveMaterial(warehousesManager, warehouseFrom, warehouseTo, material, quantity);
    }
    public void addQuantity(Warehouse warehouse, Material material, int addQuantity){
        materialService.addQuantity(warehouse,material,addQuantity);
    }
    public Material getMaterialByType(Warehouse warehouse,MaterialType materialType) {
        return materialService.getMaterialByType(warehouse, materialType);
    }
}

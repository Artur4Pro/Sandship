package org.example.validators;

import org.example.model.Material;
import org.example.model.Warehouse;
import org.example.model.WarehousesManager;

import java.util.Map;

public class Validators {

    public static boolean isRightQuantity(Material material, int quantity) {
        return (quantity >= 0 && quantity <= material.getMaxCapacity());
    }

    public static boolean isExistQuantity(Warehouse warehouse, Material material, int quantity) {
        Map<Material, Integer> materials = warehouse.getMaterials();
        return materials.get(material) >= quantity;
    }

    public static boolean isExistMaterial(Warehouse warehouse, Material material) {
        Map<Material, Integer> materials = warehouse.getMaterials();
        return materials.containsKey(material);
    }

    public static boolean isExistWarehouse(WarehousesManager warehousesManager, Warehouse warehouse) {
        return warehousesManager.getWarehouses().contains(warehouse);
    }

    public static boolean isValidQuantityForMoving(Warehouse warehouse, Material material, int quantity) {
        return (isRightQuantity(material, quantity) && isExistQuantity(warehouse, material, quantity));
    }

    public static  boolean isRightNumberInRange(int number, int range){
        return (number>0 && number<=range);
    }
}
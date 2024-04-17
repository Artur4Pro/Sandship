package org.example.validators;

import org.example.model.Material;
import org.example.model.Warehouse;
import org.example.model.WarehousesManager;

import java.util.Map;

public class Validators {

    public static boolean isRightQuantity(Material material, int quantity) {
        return (quantity >= 0 && quantity <= material.getMaxCapacity());
    }

    public static boolean isExistQuantity(Map<Material, Integer> materials, Material material, int quantity) {
        return materials.get(material) >= quantity;
    }

    public static boolean isExistMaterial(Map<Material, Integer> materials, Material material) {
        return materials.containsKey(material);
    }

    public static boolean isExistWarehouse(WarehousesManager warehousesManager, Warehouse warehouse) {
        return warehousesManager.getWarehouses().contains(warehouse);
    }

    public static boolean isValidQuantityForMoving(Map<Material, Integer> materials, Material material, int quantity) {
        return (isRightQuantity(material, quantity) && isExistQuantity(materials, material, quantity));
    }















    //   public static boolean isValidQuantityForAccepting(WarehousesManager warehousesManager, Warehouse warehouse, Material material, int quantity) {
//        int maxQuantityAccepting = -1;
//        if (isExistWarehouse(warehousesManager, warehouse)) {
//            int indexOfWarehouse = warehousesManager.getWarehouses().indexOf(warehouse);
//            if (!isExistMaterial(warehousesManager.getWarehouses().get(indexOfWarehouse).getMaterials(), material)) {
//
//                Warehouse warehouseToMove = warehousesManager.getWarehouses().get(indexOfWarehouse);
//                int existMaterialQuantity = warehouseToMove.getMaterials().get(material);
//                int maxCapacityOfExistMaterial = -1;
//                for (Map.Entry<Material, Integer> entry : warehouseToMove.getMaterials().entrySet()) {
//                    Material findMaterial = entry.getKey();
//                    if (findMaterial.getName().name().equals(material.getName().name())) {
//                        maxCapacityOfExistMaterial = (int) findMaterial.getMaxCapacity();
//                    }
//                    maxQuantityAccepting = maxCapacityOfExistMaterial - existMaterialQuantity;
//                }
//            }
//        }
//        return maxQuantityAccepting >= quantity;
//
//    }
}
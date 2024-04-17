package org.example.service;

import org.example.model.Material;
import org.example.model.Warehouse;
import org.example.model.WarehousesManager;
import org.example.utility.WarehouseInterface;
import org.example.validators.Validators;

import java.util.Map;

public class WarehouseService implements WarehouseInterface {

    @Override
    public void addMaterial(Map<Material, Integer> materials, Material material, int quantity) {
        if (Validators.isExistMaterial(materials, material)) {
            System.out.println("The material " + material.getName().name() + " has already existed in this Warehouse");
        } else if (!Validators.isRightQuantity(material, quantity)) {
            System.out.println("The quantity must be in rang from 0 to " + material.getMaxCapacity() + ". Enter right number");
        } else {
            materials.put(material, quantity);
            System.out.println("The material is added");
        }
    }

    @Override
    public void removeMaterial(Map<Material, Integer> materials, Material material) {
        if (Validators.isExistMaterial(materials, material)) {
            materials.remove(material);
            System.out.println("The material " + material.getName() + " is removed");
        } else {
            System.out.println("The material " + material.getName() + "is not exist in the Warehouse");
        }
    }

    @Override
    public int getMaterialQuantity(Map<Material, Integer> materials, Material material) {
        if (Validators.isExistMaterial(materials, material)) {
            return materials.get(material);
        } else {
            System.out.println("The material " + material.getName() + "is not exist in the Warehouse");
            return -1000;
        }
    }

    @Override
    public void getWarehouseMaterials(Map<Material, Integer> materials) {
        if (materials.isEmpty()) {
            System.out.println("This Warehouse is empty");
        } else {
            for (Map.Entry<Material, Integer> entry : materials.entrySet()) {
                Material material = entry.getKey();
                Integer quantity = entry.getValue();
                System.out.println(material.toString() + quantity);
            }
        }
    }

    @Override
    public boolean moveMaterial(WarehousesManager warehousesManager, Warehouse warehouseFrom, Warehouse warehouseTo, Material material, int quantity) {
        if (!Validators.isExistWarehouse(warehousesManager, warehouseTo)) {
            return false;
        }

        if (!Validators.isExistMaterial(warehouseFrom.getMaterials(), material)) {
            return false;
        }

        if (!Validators.isExistQuantity(warehouseFrom.getMaterials(), material, quantity)) {
            return false;
        }
        ;

        int findIndexOfWarehouse = warehousesManager.getWarehouses().indexOf(warehouseTo);
        Warehouse warehouse = warehousesManager.getWarehouses().get(findIndexOfWarehouse);

        if (!Validators.isExistMaterial(warehouse.getMaterials(), material)) {
            addMaterial(warehouse.getMaterials(), material, 0);
        }

        int maxCapacity = -1;
        int existCount = -1;

        for (Map.Entry<Material, Integer> entry : warehouse.getMaterials().entrySet()) {
            Material m = entry.getKey();
            int count = entry.getValue();
            if (m.getName().name().equals(material.getName().name())) {
                maxCapacity = (int) m.getMaxCapacity();
                existCount = count;
            }
        }

        if ((maxCapacity-existCount) < quantity) {
            return false;
        }

        addQuantity(warehouseTo.getMaterials(),material,quantity);
        reduceQuantity(warehouseFrom.getMaterials(),material,quantity);

        return true;
    }

    private void addQuantity(Map<Material, Integer> materials, Material material, int addQuantity) {
        int existQuantity = materials.get(material);
        materials.put(material,existQuantity+existQuantity);
    }


    private void reduceQuantity(Map<Material, Integer> materials, Material material, int reduceQuantity) {
        int existQuantity = materials.get(material);
        materials.put(material,existQuantity-reduceQuantity);
    }


//    @Override
//    public boolean moveMaterial(WarehousesManager warehousesManager,Warehouse warehouseFrom, Warehouse warehouseTo, Material material, int quantity) {
//        if (!Validators.isExistWarehouse(warehousesManager, warehouseTo)) {
//            System.out.println("The Warehouse " + warehouseTo.getName() + " is not found");
//            return false;
//        } else if (!Validators.isValidQuantityForAccepting(warehousesManager, warehouseTo, material, quantity)) {
//            System.out.println("The Warehouse can not accept that quantity of material");
//            return false;
//        }else {
//            int indexOfWarehouseTo = warehousesManager.getWarehouses().indexOf(warehouseTo);
//            int indexOfWarehouseFrom = warehousesManager.getWarehouses().indexOf(warehouseFrom);
//            Warehouse warehouseToMove = warehousesManager.getWarehouses().get(indexOfWarehouseTo);
//            Warehouse warehouseFromMove = warehousesManager.getWarehouses().get(indexOfWarehouseFrom);
//            int materialCountOfTo = warehousesManager.getWarehouses().get(indexOfWarehouseTo).getMaterials().get(material);
//            int materialCountOfFrom = warehousesManager.getWarehouses().get(indexOfWarehouseFrom).getMaterials().get(material);
//            addMaterial(warehouseToMove.getMaterials(),material,materialCountOfTo+quantity);
//            addMaterial(warehouseFromMove.getMaterials(),material,materialCountOfFrom-quantity);
//            return true;
//        }
//    }

}

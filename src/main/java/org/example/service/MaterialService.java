package org.example.service;

import org.example.model.Material;
import org.example.model.MaterialType;
import org.example.model.Warehouse;
import org.example.model.WarehousesManager;
import org.example.utility.MaterialInterface;
import org.example.validators.Validators;

import java.util.Map;

public class MaterialService implements MaterialInterface {
    @Override
    public Material newMaterial(MaterialType materialType, String description, String icon, int maxCapacity) {
        return newMaterial(materialType, description, icon, maxCapacity);
    }

    @Override
    public boolean addMaterial(Warehouse warehouse, Material material, int quantity) {
        Map<Material, Integer> materials = warehouse.getMaterials();
        if (Validators.isExistMaterial(materials, material)) {
            System.out.println("The material " + material.getName().name() + " has already existed in this Warehouse");
            return false;
        } else if (!Validators.isRightQuantity(material, quantity)) {
            System.out.println("The quantity must be in rang from 0 to " + material.getMaxCapacity() + ". Enter right number");
            return false;
        } else {
            materials.put(material, quantity);
            System.out.println("The material is added");
            return true;
        }
    }

    @Override
    public boolean removeMaterial(Warehouse warehouse, Material material) {
        Map<Material, Integer> materials = warehouse.getMaterials();
        if (Validators.isExistMaterial(materials, material)) {
            materials.remove(material);
            System.out.println("The material " + material.getName() + " is removed");
            return true;
        } else {
            System.out.println("The material " + material.getName() + "is not exist in the Warehouse");
            return false;
        }
    }

    @Override
    public int getMaterialQuantity(Warehouse warehouse, Material material) {
        Map<Material, Integer> materials = warehouse.getMaterials();
        if (Validators.isExistMaterial(materials, material)) {
            return materials.get(material);
        } else {
            System.out.println("The material " + material.getName() + "is not exist in the Warehouse");
            return -1000;
        }
    }

    @Override
    public void getWarehouseMaterials(Warehouse warehouse) {
        Map<Material, Integer> materials = warehouse.getMaterials();
        if (materials.isEmpty()) {
            System.out.println("This Warehouse is empty");
        } else {
            System.out.println("__________________________");
            for (Map.Entry<Material, Integer> entry : materials.entrySet()) {
                Material material = entry.getKey();
                Integer quantity = entry.getValue();
                System.out.println( material.getId() +" | "+material.toString() + quantity + "/" +material.getMaxCapacity());
            }
            System.out.println("__________________________");
        }
    }

    @Override
    public boolean moveMaterial(WarehousesManager warehousesManager, Warehouse warehouseFrom, Warehouse warehouseTo, Material material, int quantity) {
        if (!Validators.isExistWarehouse(warehousesManager, warehouseTo)) {
            System.out.println("The Warehouse " + warehouseTo.getName() + " is not exist");
            return false;
        }

        if (!Validators.isExistQuantity(warehouseFrom.getMaterials(), material, quantity)) {
            System.out.println("You does not have that quantity of material");
            return false;
        }
        ;

        int findIndexOfWarehouse = warehousesManager.getWarehouses().indexOf(warehouseTo);

        Warehouse warehouse = warehousesManager.getWarehouses().get(findIndexOfWarehouse);

        if (!Validators.isExistMaterial(warehouse.getMaterials(), material)) {
            addMaterial(warehouse, material, 0);
        }
        Material material1 = null;
        int maxCapacity = -1;
        int existCount = -1;

        for (Map.Entry<Material, Integer> entry : warehouse.getMaterials().entrySet()) {
            Material m = entry.getKey();
            int count = entry.getValue();
            if (m.getName().name().equals(material.getName().name())) {
                maxCapacity = (int) m.getMaxCapacity();
                existCount = count;
                material1 = m;
            }
        }

        if (!Validators.isRightQuantity(material1, quantity) || (quantity > maxCapacity - existCount)) {
            System.out.println("The quantity is too big");
            return false;
        }

        addQuantity(warehouse, material, quantity);
        reduceQuantity(warehouseFrom, material, quantity);

        return true;
    }


    @Override
    public void addQuantity(Warehouse warehouse, Material material, int addQuantity) {
        Map<Material, Integer> materials = warehouse.getMaterials();
        int existQuantity = materials.get(material);
        materials.put(material, existQuantity + addQuantity);
    }


    private void reduceQuantity(Warehouse warehouse, Material material, int reduceQuantity) {
        Map<Material, Integer> materials = warehouse.getMaterials();
        int existQuantity = materials.get(material);
        materials.put(material, existQuantity - reduceQuantity);
    }
}

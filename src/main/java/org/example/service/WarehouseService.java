package org.example.service;

import org.example.model.Material;
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
}

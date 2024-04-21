package org.example.controller;

import org.example.exception.GeneralException;
import org.example.model.Material;
import org.example.model.MaterialType;
import org.example.model.Warehouse;
import org.example.model.WarehouseCollection;
import org.example.service.Impl.WarehouseService;

public class WarehouseController {

    private final WarehouseService warehouseService = new WarehouseService();

    /**
     * Creates a new warehouse with the specified name.
     *
     * <p>This method delegates the creation of the warehouse to the warehouse service.
     * If any exception occurs during the process, such as a GeneralException, it prints the
     * error message to the console and returns null.
     *
     * <p>When using this method, ensure to handle potential exceptions and check for null
     * return value.
     **/
    public Warehouse createWarehouse(String name) {
        return warehouseService.creatWarehouse(name);
    }

    /**
     * Adds the specified quantity of the given material to the provided warehouse.
     *
     * <p>This method delegates the addition of material to the warehouse service.
     * If any exception occurs during the process, such as a GeneralException, it prints the
     * error message to the console and returns false.
     **/
    public boolean addMaterial(Warehouse warehouse, Material material, int quantity) {
        try {
            return warehouseService.addMaterial(warehouse, material, quantity);
        } catch (GeneralException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * Removes the specified material from the given warehouse.
     *
     * <p>This method delegates the removal of material to the warehouse service.
     * If any exception occurs during the process, such as a GeneralException, it prints the
     * error message to the console and returns false.
     **/
    public boolean removeMaterial(Warehouse warehouse, Material material) {
        try {
            return warehouseService.removeMaterial(warehouse, material);
        } catch (GeneralException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * Prints the materials stored in the specified warehouse.
     *
     * <p>This method delegates the printing of warehouse materials to the warehouse service.
     * If any exception occurs during the process, such as a GeneralException, it prints the
     * error message to the console.
     **/
    public void printWarehouseMaterials(Warehouse warehouse) {
        try {
            warehouseService.printWarehouseMaterials(warehouse);
        } catch (GeneralException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Moves a specified quantity of material from one warehouse to another within the given warehouse collection.
     *
     * <p>This method catches any GeneralException that might occur during the material movement operation
     * and prints its message. It returns false if an exception occurs, otherwise returns true.
     **/
     public boolean moveMaterial(WarehouseCollection warehouseCollection, Warehouse warehouseFrom, Warehouse warehouseTo, Material material, int quantity) {
        try {
            return warehouseService.moveMaterial(warehouseCollection, warehouseFrom, warehouseTo, material, quantity);
        } catch (GeneralException e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    /**
     * Retrieves a material of the specified type from the given warehouse.
     *
     * <p>Note: When using this method, make sure to handle any potential exceptions
     * thrown by the underlying implementation, such as GeneralException. Also, keep in mind
     * that this method may return null if the material of the specified type is not found.
     **/
    public Material getMaterialByType(Warehouse warehouse, MaterialType materialType) {
        return warehouseService.getMaterialByType(warehouse, materialType);
    }
}

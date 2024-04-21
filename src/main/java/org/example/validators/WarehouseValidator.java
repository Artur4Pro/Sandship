package org.example.validators;

import org.example.exception.GeneralException;
import org.example.model.Material;
import org.example.model.Warehouse;

import java.util.Map;

public class WarehouseValidator {

    /**
     * Validates that the provided name is not empty.
     * Throws a GeneralException if the name is null or empty.
     *
     * @param name The name to validate.
     * @throws GeneralException If the name is null or empty.
     */
    public void validateNonEmptyName(String name) {
        if (name == null || name.isEmpty()) {
            throw new GeneralException("Name cannot be empty.");
        }
    }

    /**
     * Validates the quantity of a material.
     * Throws a GeneralException if the quantity is invalid.
     *
     * @param material The material for which the quantity is being validated.
     * @param quantity The quantity to validate.
     * @throws GeneralException If the quantity is negative or exceeds the maximum capacity of the material.
     */
    public void validateMaterialQuantity(Material material, int quantity) {
        if (quantity < 0) {
            throw new GeneralException("Invalid quantity: " + quantity + ". Quantity is less then 0.");
        }
        if (quantity > material.getMaxCapacity()) {
            throw new GeneralException("Invalid quantity: " + quantity + ". Quantity is greater than the max capacity.");
        }
    }

    /**
     * Validates the non-existence of a material in a warehouse.
     * Throws a GeneralException if the material already exists in the warehouse.
     *
     * @param warehouse The warehouse to check for material existence.
     * @param material  The material to check for existence.
     * @throws GeneralException If the material already exists in the warehouse.
     */
    public void validateMaterialNonExistence(Warehouse warehouse, Material material) {
        Map<Material, Integer> materials = warehouse.getMaterials();

        if (materials.containsKey(material)) {
            throw new GeneralException("Material: " + material.getName() + " already exist in " + warehouse.getName() + ".");
        }
    }

    /**
     * Validates the existence of a material in a warehouse.
     * Throws a GeneralException if the material does not exist in the warehouse.
     *
     * @param warehouse The warehouse to check for material existence.
     * @param material  The material to check for existence.
     * @throws GeneralException If the material does not exist in the warehouse.
     */
    public void validateMaterialExistence(Warehouse warehouse, Material material) {
        Map<Material, Integer> materials = warehouse.getMaterials();

        if (!materials.containsKey(material)) {
            throw new GeneralException("Material: " + material.getName() + " does not exist in " + warehouse.getName() + ".");
        }
    }

    /**
     * Validates the quantity of a material for moving from a warehouse.
     * Throws a GeneralException if the quantity is invalid or insufficient.
     *
     * @param warehouseFrom The warehouse from which the material is being moved.
     * @param material      The material being moved.
     * @param quantity      The quantity being moved.
     * @throws GeneralException If the quantity is negative or if the warehouse has insufficient quantity of the material.
     */
    public void validateQuantityForMoving(Warehouse warehouseFrom, Material material, int quantity) {
        if (quantity < 0) {
            throw new GeneralException("Invalid quantity: " + quantity + ". Quantity is less then 0.");
        }
        if (warehouseFrom.getMaterials().get(material) < quantity) {
            throw new GeneralException("Insufficient quantity of material.");
        }
    }

    /**
     * Validates that a warehouse object is not null.
     * Throws a GeneralException if the warehouse object is null.
     *
     * @param warehouse The warehouse object to validate.
     * @throws GeneralException If the warehouse object is null.
     */
    public void validateWarehouseNotNull(Warehouse warehouse) {
        if (warehouse == null) {
            throw new GeneralException("The warehouse is null.");
        }
    }

    /**
     * Validates that a warehouse is not empty.
     * Throws a GeneralException if the warehouse is empty.
     *
     * @param warehouse The warehouse to validate.
     * @throws GeneralException If the warehouse is empty.
     */
    public void validateNonEmptyWarehouse(Warehouse warehouse) {
        if (warehouse.getMaterials().isEmpty()) {
            throw new GeneralException("The warehouse is empty.");
        }
    }
}

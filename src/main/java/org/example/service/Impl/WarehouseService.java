package org.example.service.Impl;

import org.example.model.Material;
import org.example.model.MaterialType;
import org.example.model.Warehouse;
import org.example.model.WarehouseCollection;
import org.example.service.WarehouseInterface;
import org.example.validators.MaterialValidator;
import org.example.validators.Validator;
import org.example.validators.WarehouseCollectionValidator;
import org.example.validators.WarehouseValidator;

import java.util.Map;

public class WarehouseService implements WarehouseInterface {
    private final Validator validator = new Validator();
    private final MaterialValidator materialValidator = new MaterialValidator();
    private final WarehouseValidator warehouseValidator = new WarehouseValidator();
    private final WarehouseCollectionValidator warehouseCollectionValidator = new WarehouseCollectionValidator();

    @Override
    public Warehouse creatWarehouse(String name) {

        // Validate that the warehouse name is not empty
        warehouseValidator.validateNonEmptyName(name);

        return new Warehouse(name);
    }

    @Override
    public boolean addMaterial(Warehouse warehouse, Material material, int quantity) {

        // Validate that the warehouse object is not null
        warehouseValidator.validateWarehouseNotNull(warehouse);

        // Validate that the material object is not null
        materialValidator.validateNonNullMaterial(material);

        // Validate that the material does not already exist in the warehouse
        warehouseValidator.validateMaterialNonExistence(warehouse, material);

        // Validate that the quantity is valid
        warehouseValidator.validateMaterialQuantity(material, quantity);

        // Get the map of materials from the warehouse
        Map<Material, Integer> materials = warehouse.getMaterials();

        // Add the material to the warehouse with the specified quantity
        materials.put(material, quantity);

        return true;
    }

    @Override
    public boolean removeMaterial(Warehouse warehouse, Material material) {

        // Validate that the warehouse object is not null
        warehouseValidator.validateWarehouseNotNull(warehouse);

        // Validate that the material object is not null
        materialValidator.validateNonNullMaterial(material);

        // Validate that the material exists in the warehouse
        warehouseValidator.validateMaterialExistence(warehouse, material);

        // Remove the material from the warehouse
        warehouse.getMaterials().remove(material);
        return true;
    }


    @Override
    public void printWarehouseMaterials(Warehouse warehouse) {

        // Validate that the warehouse object is not null
        warehouseValidator.validateWarehouseNotNull(warehouse);

        // Get the map of materials from the warehouse
        Map<Material, Integer> materials = warehouse.getMaterials();

        if (materials.isEmpty()) {
            System.out.println("Тhe warehouse is empty.");
        } else {
            for (Map.Entry<Material, Integer> entry : materials.entrySet()) {
                Material material = entry.getKey();
                Integer quantity = entry.getValue();
                System.out.println(material.toString() + quantity + "/" + material.getMaxCapacity());
            }
        }
    }

    @Override
    public boolean moveMaterial(WarehouseCollection warehouseCollection, Warehouse warehouseFrom, Warehouse warehouseTo, Material material, int quantity) {

        // Ensure that none of the provided objects are null
        validator.assertNoNulls(warehouseCollection, warehouseFrom, warehouseTo, material);

        // Validate the existence of the source warehouse in the warehouse collection
        warehouseCollectionValidator.validateWarehouseExistence(warehouseCollection, warehouseFrom);

        // Validate the existence of the destination warehouse in the warehouse collection
        warehouseCollectionValidator.validateWarehouseExistence(warehouseCollection, warehouseTo);

        // Validate the existence of the material in the source warehouse
        warehouseValidator.validateMaterialExistence(warehouseFrom, material);

        // Validate that the quantity to move is valid
        warehouseValidator.validateQuantityForMoving(warehouseFrom, material, quantity);

        // If the material does not exist in the destination warehouse, add it with a quantity of 0
        if (!warehouseTo.getMaterials().containsKey(material)) {
            addMaterial(warehouseTo, material, 0);
        }

        // Increase the quantity of the material in the destination warehouse
        increaseTheMaterialQuantity(warehouseTo, material, quantity);

        // Decrease the quantity of the material in the source warehouse
        decreaseTheMaterialQuantity(warehouseFrom, material, quantity);

        return true;
    }

    @Override
    public Material getMaterialByType(Warehouse warehouse, MaterialType materialType) {
        // Validate that the warehouse object is not null
        warehouseValidator.validateWarehouseNotNull(warehouse);
        // Validate that the warehouse is not empty
        warehouseValidator.validateNonEmptyWarehouse(warehouse);
        // Validate that the material type is not null
        materialValidator.validateNonNullMaterialType(materialType);

        Map<Material, Integer> materials = warehouse.getMaterials();

        Material material = null;

        for (Map.Entry<Material, Integer> entry : materials.entrySet()) {
            Material m = entry.getKey();
            if (m.getName().name().equals(materialType.name())) {
                material = m;
            }
        }

        return material;
    }


    /**
     * Increases the quantity of a material by the specified amount in the given warehouse.
     *
     * @param warehouse   The warehouse where the material quantity is being increased.
     * @param material    The material whose quantity is to be increased.
     * @param addQuantity The amount by which to increase the current quantity of the material.
     */
    private void increaseTheMaterialQuantity(Warehouse warehouse, Material material, int addQuantity) {

        Map<Material, Integer> materials = warehouse.getMaterials();

        int existQuantity = materials.get(material);

        materials.put(material, existQuantity + addQuantity);
    }

    /**
     * Reduces the quantity of the specified material in the warehouse by the given amount.
     *
     * @param warehouse      The warehouse to reduce the quantity in.
     * @param material       The material to reduce the quantity of.
     * @param reduceQuantity The quantity to reduce.
     */
    private void decreaseTheMaterialQuantity(Warehouse warehouse, Material material, int reduceQuantity) {

        Map<Material, Integer> materials = warehouse.getMaterials();

        int existQuantity = materials.get(material);

        materials.put(material, existQuantity - reduceQuantity);
    }
}

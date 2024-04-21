package org.example.service;

import org.example.model.Material;
import org.example.model.MaterialType;
import org.example.model.Warehouse;
import org.example.model.WarehouseCollection;

/**
 * Defines the interface for a material.
 * This interface specifies the methods and properties that a class representing a material should provide.
 */
public interface WarehouseInterface {

    /**
     * Creates a new instance of the Warehouse class with the specified name.
     *
     * @param name The name of the warehouse to be created.
     * @return A new Warehouse object with the given name.
     */
    public Warehouse creatWarehouse(String name);


    /**
     * Adds the specified quantity of the given material to the warehouse.
     *
     * @param warehouse The warehouse to add the material to.
     * @param material  The material to add.
     * @param quantity  The quantity of the material to add.
     * @return True if the material was successfully added, false otherwise.
     */
    public boolean addMaterial(Warehouse warehouse, Material material, int quantity);


    /**
     * Removes the specified material from the warehouse.
     *
     * @param warehouse The warehouse to remove the material from.
     * @param material  The material to remove.
     * @return True if the material was successfully removed, false otherwise.
     */
    public boolean removeMaterial(Warehouse warehouse, Material material);


    /**
     * Prints the list of materials and their quantities, including material type, description, icon,
     * quantity, and maximum capacity, in the specified warehouse.
     *
     * @param warehouse The warehouse to get the materials from.
     */
    public void printWarehouseMaterials(Warehouse warehouse);


    /**
     * Moves the specified quantity of the given material from one warehouse to another.
     *
     * @param warehouseCollection The manager managing the warehouses.
     * @param warehouseFrom       The warehouse to move the material from.
     * @param warehouseTo         The warehouse to move the material to.
     * @param material            The material to move.
     * @param quantity            The quantity of the material to move.
     * @return True if the material was successfully moved, false otherwise.
     */
    public boolean moveMaterial(WarehouseCollection warehouseCollection, Warehouse warehouseFrom, Warehouse warehouseTo, Material material, int quantity);


    /**
     * Returns the material of the specified type in the warehouse, if it exists.
     *
     * @param warehouse    The warehouse to search for the material in.
     * @param materialType The type of material to search for.
     * @return The material of the specified type in the warehouse, or null if not found.
     */
    public Material getMaterialByType(Warehouse warehouse, MaterialType materialType);
}

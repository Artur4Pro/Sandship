package org.example.utility;

import org.example.model.Material;
import org.example.model.MaterialType;
import org.example.model.Warehouse;
import org.example.model.WarehousesManager;

public interface MaterialInterface {


    /**
     * Creates a new material with the specified type, description, icon, and maximum capacity.
     *
     * @param materialType The type of the material.
     * @param description  The description of the material.
     * @param icon         The icon representing the material.
     * @param maxCapacity  The maximum capacity of the material.
     * @return The newly created material.
     */
    public Material newMaterial(MaterialType materialType , String description, String icon , int maxCapacity);


    /**
     * Adds the specified quantity of the given material to the warehouse.
     *
     * @param warehouse The warehouse to add the material to.
     * @param material  The material to add.
     * @param quantity  The quantity of the material to add.
     * @return True if the material was successfully added, false otherwise.
     */
    public boolean addMaterial(Warehouse warehouse, Material material , int quantity);


    /**
     * Removes the specified material from the warehouse.
     *
     * @param warehouse The warehouse to remove the material from.
     * @param material  The material to remove.
     * @return True if the material was successfully removed, false otherwise.
     */
    public boolean removeMaterial(Warehouse warehouse , Material material);


    /**
     * Returns the quantity of the specified material in the warehouse.
     *
     * @param warehouse The warehouse to check the material quantity in.
     * @param material  The material to get the quantity of.
     * @return The quantity of the material in the warehouse.
     */
    public int getMaterialQuantity(Warehouse warehouse ,Material material);


    /**
     * Prints the list of materials and their quantities, including material type, description, icon,
     * quantity, and maximum capacity, in the specified warehouse.
     *
     * @param warehouse The warehouse to get the materials from.
     */
    public void showWarehouseMaterials(Warehouse warehouse);


    /**
     * Moves the specified quantity of the given material from one warehouse to another.
     *
     * @param warehousesManager The manager managing the warehouses.
     * @param warehouseFrom      The warehouse to move the material from.
     * @param warehouseTo        The warehouse to move the material to.
     * @param material           The material to move.
     * @param quantity           The quantity of the material to move.
     * @return True if the material was successfully moved, false otherwise.
     */
    public boolean moveMaterial(WarehousesManager warehousesManager , Warehouse warehouseFrom, Warehouse warehouseTo , Material material , int quantity);


    /**
     * Increases the quantity of the specified material in the warehouse by the given amount.
     *
     * @param warehouse   The warehouse to add the quantity to.
     * @param material    The material to increase the quantity of.
     * @param addQuantity The quantity to add.
     */
    public void increaseQuantity(Warehouse warehouse, Material material, int addQuantity);


    /**
     * Returns the material of the specified type in the warehouse, if it exists.
     *
     * @param warehouse    The warehouse to search for the material in.
     * @param materialType The type of material to search for.
     * @return The material of the specified type in the warehouse, or null if not found.
     */
    public Material getMaterialByType(Warehouse warehouse,MaterialType materialType);
}

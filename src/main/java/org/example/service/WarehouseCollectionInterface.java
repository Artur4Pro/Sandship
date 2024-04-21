package org.example.service;

import org.example.model.Warehouse;
import org.example.model.WarehouseCollection;

/**
 * Defines the interface for a warehouse.
 * This interface specifies the methods that a class implementing a warehouse should provide.
 */
public interface WarehouseCollectionInterface {

    /**
     * Adds a new warehouse to the warehouses' manager.
     *
     * @param warehouseCollection The warehouses manager to add the warehouse to.
     * @param warehouse           The warehouse to add.
     */
    public void addWarehouse(WarehouseCollection warehouseCollection, Warehouse warehouse);

    /**
     * Prints the names of the warehouses managed by the specified warehouses manager.
     *
     * @param warehouseCollection The warehouses manager whose warehouses list will be displayed.
     */
    public void showWarehousesList(WarehouseCollection warehouseCollection);
}

package org.example.utility;

import org.example.model.Material;
import org.example.model.Warehouse;
import org.example.model.WarehousesManager;

import java.util.List;
import java.util.Map;

public interface WarehouseInterface {


    /**
     * Adds a new warehouse to the warehouses' manager.
     *
     * @param warehousesManager The warehouses manager to add the warehouse to.
     * @param warehouse         The warehouse to add.
     */
    public void addWarehouse(WarehousesManager warehousesManager, Warehouse warehouse);


    /**
     * Prints the names of the warehouses managed by the specified warehouses manager.
     *
     * @param warehousesManager The warehouses manager whose warehouses list will be displayed.
     */
    public void showWarehousesList(WarehousesManager warehousesManager);


    /**
     * Prints the names of the warehouses managed by the specified warehouses manager,
     * excluding the name of the selected warehouse.
     *
     * @param warehousesManager The warehouses manager whose warehouses list will be displayed.
     * @param warehouse         The warehouse whose name should be excluded from the list.
     */
    public void showWarehousesListWithoutSelectedWarehouse(WarehousesManager warehousesManager,Warehouse warehouse);


    /**
     * Returns the warehouse at the specified index in the warehouses manager's list.
     *
     * @param warehousesManager The warehouses manager containing the list of warehouses.
     * @param index             The index of the warehouse to retrieve.
     * @return The warehouse at the specified index, or null if the index is out of bounds.
     */
    public Warehouse getWarehouse(WarehousesManager warehousesManager, int index);


}

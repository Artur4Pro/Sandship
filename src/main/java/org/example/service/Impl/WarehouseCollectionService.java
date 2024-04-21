package org.example.service.Impl;

import org.example.model.Warehouse;
import org.example.model.WarehouseCollection;
import org.example.service.WarehouseCollectionInterface;
import org.example.validators.WarehouseCollectionValidator;
import org.example.validators.WarehouseValidator;

import java.util.List;

public class WarehouseCollectionService implements WarehouseCollectionInterface {

    private final WarehouseCollectionValidator warehouseCollectionValidator = new WarehouseCollectionValidator();
    private final WarehouseValidator warehouseValidator = new WarehouseValidator();

    @Override
    public void addWarehouse(WarehouseCollection warehouseCollection, Warehouse warehouse) {

        // Validate that the warehouse collection is not null
        warehouseCollectionValidator.validateNonNullWarehouseCollection(warehouseCollection);

        // Validate that the warehouse object is not null
        warehouseValidator.validateWarehouseNotNull(warehouse);

        // Validate that the warehouse does not already exist in the warehouse collection
        warehouseCollectionValidator.validateWarehouseNonExistence(warehouseCollection, warehouse);

        // Add the warehouse to the warehouse collection
        warehouseCollection.getWarehouses().add(warehouse);
    }

    @Override
    public void showWarehousesList(WarehouseCollection warehouseCollection) {

        // Validate that the warehouse collection is not null
        warehouseCollectionValidator.validateNonNullWarehouseCollection(warehouseCollection);

        // Get the list of warehouses from the warehouse collection
        List<Warehouse> warehouses = warehouseCollection.getWarehouses();

        if (warehouses.isEmpty()) {
            System.out.println("The List of Warehouses is empty you can create new ! ");
        } else {
            for (Warehouse x : warehouses) {
                System.out.println(x.getName());
            }
        }
    }
}



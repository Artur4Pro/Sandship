package org.example.validators;

import org.example.exception.GeneralException;
import org.example.model.Warehouse;
import org.example.model.WarehouseCollection;

import java.util.List;

public class WarehouseCollectionValidator {

    /**
     * Validates that a warehouse collection is not null.
     * Throws a GeneralException if the warehouse collection is null.
     *
     * @param warehouseCollection The warehouse collection to validate.
     * @throws GeneralException If the warehouse collection is null.
     */
    public void validateNonNullWarehouseCollection(WarehouseCollection warehouseCollection) {
        if (warehouseCollection == null) {
            throw new GeneralException("Warehouse collection cannot be null.");
        }
    }

    /**
     * Validates that a warehouse does not already exist in a warehouse collection.
     * Throws a GeneralException if the warehouse already exists.
     *
     * @param warehouseCollection The warehouse collection to check for warehouse existence.
     * @param warehouse           The warehouse to check for existence.
     * @throws GeneralException If the warehouse already exists in the warehouse collection.
     */
    public void validateWarehouseNonExistence(WarehouseCollection warehouseCollection, Warehouse warehouse) {
        if (warehouseCollection.getWarehouses().contains(warehouse)) {
            throw new GeneralException("The warehouse " + warehouse.getName() + " is already exist.");
        }
    }

    /**
     * Validates that a warehouse exists in a warehouse collection.
     * Throws a GeneralException if the warehouse does not exist.
     *
     * @param warehouseCollection The warehouse collection to check for warehouse existence.
     * @param warehouse           The warehouse to check for existence.
     * @throws GeneralException If the warehouse does not exist in the warehouse collection.
     */
    public void validateWarehouseExistence(WarehouseCollection warehouseCollection, Warehouse warehouse) {
        if (!warehouseCollection.getWarehouses().contains(warehouse)) {
            throw new GeneralException("The warehouse " + warehouse.getName() + " is not exist.");
        }
    }
}

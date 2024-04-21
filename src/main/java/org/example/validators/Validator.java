package org.example.validators;

import org.example.exception.GeneralException;
import org.example.model.Material;
import org.example.model.Warehouse;
import org.example.model.WarehouseCollection;

public class Validator {

    /**
     * Asserts that none of the provided objects are null.
     * Throws a GeneralException if any of the objects is null.
     *
     * @param warehouseCollection The warehouse collection to check for null.
     * @param warehouseFrom       The source warehouse to check for null.
     * @param warehouseTo         The destination warehouse to check for null.
     * @param material            The material to check for null.
     * @throws GeneralException If any of the provided objects is null.
     */
    public void assertNoNulls(WarehouseCollection warehouseCollection, Warehouse warehouseFrom, Warehouse warehouseTo, Material material) {
        if (warehouseCollection == null) {
            throw new GeneralException("Warehouse collection is null.");
        }

        if (warehouseFrom == null) {
            throw new GeneralException("Warehouse FROM is null.");
        }

        if (warehouseTo == null) {
            throw new GeneralException("Warehouse TO is null.");
        }

        if (material == null) {
            throw new GeneralException("Material is null.");
        }
    }
}
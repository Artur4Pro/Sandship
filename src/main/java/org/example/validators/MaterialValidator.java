package org.example.validators;

import org.example.exception.GeneralException;
import org.example.model.Material;
import org.example.model.MaterialType;

public class MaterialValidator {

    /**
     * Validates that the maximum capacity is a positive value.
     * Throws a GeneralException if the maximum capacity is not positive.
     *
     * @param maxCapacity The maximum capacity to validate.
     * @throws GeneralException If the maximum capacity is not positive.
     */
    public void validatePositiveMaxCapacity(int maxCapacity) {
        if (maxCapacity <= 0) {
            throw new GeneralException("Maximum capacity must be greater than 0.");
        }
    }

    /**
     * Validates that a material type is not null.
     * Throws a GeneralException if the material type is null.
     *
     * @param materialType The material type to validate.
     * @throws GeneralException If the material type is null.
     */
    public void validateNonNullMaterialType(MaterialType materialType) {
        if (materialType == null) {
            throw new GeneralException("Material type is null.");
        }
    }

    /**
     * Validates that a material object is not null.
     * Throws a GeneralException if the material object is null.
     *
     * @param material The material object to validate.
     * @throws GeneralException If the material object is null.
     */
    public void validateNonNullMaterial(Material material) {
        if (material == null) {
            throw new GeneralException("Material is null.");
        }
    }
}

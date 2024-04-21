package org.example.service.Impl;

import org.example.model.Material;
import org.example.model.MaterialType;
import org.example.service.MaterialInterface;
import org.example.validators.MaterialValidator;

public class MaterialService implements MaterialInterface {

    private final MaterialValidator materialValidator = new MaterialValidator();

    @Override
    public Material createMaterial(MaterialType materialType, String description, String icon, int maxCapacity) {

        // Validate that the maximum capacity is a positive value
        materialValidator.validatePositiveMaxCapacity(maxCapacity);

        // Validate that the material type is not null
        materialValidator.validateNonNullMaterialType(materialType);

        return new Material(materialType, description, icon, maxCapacity);
    }
}

package org.example.service;

import org.example.model.Material;
import org.example.model.MaterialType;

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
    public Material createMaterial(MaterialType materialType, String description , String icon, int maxCapacity);
}

package org.example.controller;

import org.example.exception.GeneralException;
import org.example.model.Material;
import org.example.model.MaterialType;
import org.example.service.Impl.MaterialService;

public class MaterialController {

    private final MaterialService materialService = new MaterialService();

    /**
     * Creates a new material with the provided parameters.
     *
     * <p>This method delegates the creation of the material to the material service.
     * If any exception occurs during the process, such as a GeneralException, it prints the
     * error message to the console and returns null.
     **/
    public Material createMaterial(MaterialType materialType, String description, String icon, int maxCapacity) {
        try {
            return materialService.createMaterial(materialType, description, icon, maxCapacity);
        } catch (GeneralException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}

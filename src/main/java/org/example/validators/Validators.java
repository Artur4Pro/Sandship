package org.example.validators;

import org.example.model.Material;

import java.util.Map;

public class Validators {

    public static boolean isRightQuantity(Material material , int quantity){
        return (quantity >= 0 && quantity <= material.getMaxCapacity());
    }

    public static boolean isExistMaterial(Map<Material, Integer> materials , Material material){
        return materials.containsKey(material);
    }
}

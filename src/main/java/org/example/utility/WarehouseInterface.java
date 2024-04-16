package org.example.utility;

import org.example.model.Material;

import java.util.Map;

public interface WarehouseInterface {

    public void addMaterial(Map <Material, Integer> materials , Material material , int quantity);
    public void removeMaterial(Map <Material, Integer> materials , Material material);
    public int getMaterialQuantity(Map <Material, Integer> materials ,Material material);
    public void getWarehouseMaterials(Map <Material , Integer> materials);

}

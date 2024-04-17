package org.example.utility;

import org.example.model.Material;
import org.example.model.Warehouse;
import org.example.model.WarehousesManager;

import java.util.Map;

public interface WarehouseInterface {

    public void addMaterial(Map <Material, Integer> materials , Material material , int quantity);
    public void removeMaterial(Map <Material, Integer> materials , Material material);
    public int getMaterialQuantity(Map <Material, Integer> materials ,Material material);
    public void getWarehouseMaterials(Map <Material , Integer> materials);
    public boolean moveMaterial(WarehousesManager warehousesManager , Warehouse warehouseFrom, Warehouse warehouseTo , Material material , int quantity);


}

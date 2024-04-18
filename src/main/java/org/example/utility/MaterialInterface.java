package org.example.utility;

import org.example.model.Material;
import org.example.model.MaterialType;
import org.example.model.Warehouse;
import org.example.model.WarehousesManager;

import java.util.Map;

public interface MaterialInterface {
    public Material newMaterial(MaterialType materialType , String description, String icon , int maxCapacity);
    public boolean addMaterial(Warehouse warehouse, Material material , int quantity);
    public boolean removeMaterial(Warehouse warehouse , Material material);
    public int getMaterialQuantity(Warehouse warehouse ,Material material);
    public void getWarehouseMaterials(Warehouse warehouse);
    public boolean moveMaterial(WarehousesManager warehousesManager , Warehouse warehouseFrom, Warehouse warehouseTo , Material material , int quantity);
    public void addQuantity(Warehouse warehouse, Material material, int addQuantity);
}

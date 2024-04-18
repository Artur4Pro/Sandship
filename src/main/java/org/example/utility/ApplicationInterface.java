package org.example.utility;

import org.example.model.Material;
import org.example.model.MaterialType;
import org.example.model.Warehouse;

public interface ApplicationInterface {
    public String addName();
    public String addDescription();
    public String addIcon();
    public int addMaxQuantity();

    public int quantity(Material material);
    public MaterialType materialType();
    public Material newMaterial();
    public Warehouse newWarehouse();

    public int selectNumber();
    public void printName(String name);
    public void warehouseMenu();
    public void start();
}

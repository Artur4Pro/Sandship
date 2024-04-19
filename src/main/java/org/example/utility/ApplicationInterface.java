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

    public int enterNumber();
    public void printName(String name);
    public void startPage();
    public void warehousePage();
    public void startMenu();
    public void warehouseMenu();
    public void greeting();
    public void goodBy();

}

package org.example;


import org.example.controller.WarehouseController;
import org.example.service.WarehouseService;
import org.example.model.Material;
import org.example.model.MaterialType;
import org.example.model.Warehouse;

public class Main {
    public static void main(String[] args) {

        Warehouse warehouse = new Warehouse("Arman");

        Material material1 = new Material(MaterialType.COPPER,"asdas","aasdf",150);
        Material material2 = new Material(MaterialType.BOLT,"werwer","sggf",200);
        Material material3 = new Material(MaterialType.IRON,"fhfg","ggggg",100);
        Material material4 = new Material(MaterialType.IRON,"fhfg","ggggg",100);

        WarehouseController warehouseController = new WarehouseController();

        warehouseController.addMaterial(warehouse.getMaterials(),material1,140);
        warehouseController.addMaterial(warehouse.getMaterials(),material2,200);
        warehouseController.addMaterial(warehouse.getMaterials(), material3,101);
        warehouseController.addMaterial(warehouse.getMaterials(), material4,88);

        System.out.println(warehouseController.getMaterialQuantity(warehouse.getMaterials(), material1));
        warehouseController.getWarehouseMaterials(warehouse.getMaterials());
        warehouseController.removeMaterial(warehouse.getMaterials(),material2);
        warehouseController.getWarehouseMaterials(warehouse.getMaterials());

    }
}
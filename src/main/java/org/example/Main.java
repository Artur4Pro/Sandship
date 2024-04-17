package org.example;


import org.example.controller.WarehouseController;
import org.example.controller.WarehousesManagerController;
import org.example.model.Material;
import org.example.model.MaterialType;
import org.example.model.Warehouse;
import org.example.model.WarehousesManager;

public class Main {
    public static void main(String[] args) {

        WarehousesManager warehousesManager = WarehousesManager.INSTANCE;

        WarehousesManagerController warehousesManagerController = new WarehousesManagerController();


        Warehouse warehouse = new Warehouse("Goxt");
        Warehouse warehouse1 = new Warehouse("Garni");

        WarehouseController warehouseController = new WarehouseController();

        warehousesManagerController.addWarehouse(warehousesManager, warehouse);
        warehousesManagerController.addWarehouse(warehousesManager, warehouse1);

        Material material1 = new Material(MaterialType.COPPER, "asdas", "aasdf", 150);
        Material material2 = new Material(MaterialType.BOLT, "werwer", "sggf", 200);
        Material material3 = new Material(MaterialType.IRON, "fhfg", "ggggg", 100);
        Material material4 = new Material(MaterialType.IRON, "fhfg", "ggggg", 100);

        //add
        warehouseController.addMaterial(warehouse.getMaterials(), material1, 140);
//        warehouseController.addMaterial(warehouse.getMaterials(),material2,200);
//        warehouseController.addMaterial(warehouse.getMaterials(), material3,101);
//        warehouseController.addMaterial(warehouse.getMaterials(), material4,88);

        warehouseController.addMaterial(warehouse1.getMaterials(), material2, 40);

        //
        System.out.println(warehouseController.getMaterialQuantity(warehouse.getMaterials(), material1));
        System.out.println("---------------------------");
        warehouseController.getWarehouseMaterials(warehouse.getMaterials());
        System.out.println("---------------------------");
        warehouseController.removeMaterial(warehouse.getMaterials(), material2);
        System.out.println("---------------------------");
        warehouseController.getWarehouseMaterials(warehouse.getMaterials());
        System.out.println("---------------------------");
        System.out.println("---------------------------");
        //move
        warehouseController.moveMaterial(warehousesManager, warehouse, warehouse1, material1, 100);

        warehouseController.getWarehouseMaterials(warehouse1.getMaterials());
        System.out.println("---------------------------");
        System.out.println("---------------------------");
        warehouseController.getWarehouseMaterials(warehouse.getMaterials());

    }
}
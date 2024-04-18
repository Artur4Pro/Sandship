package org.example;


import org.example.controller.ApplicationController;
import org.example.model.MaterialType;

public class Main {
    public static void main(String[] args) {


        ApplicationController applicationController = new ApplicationController();
        System.out.println("\u001B[35m" + """
                █░░░█ █▀▀ █░░ █▀▀ █▀▀█ █▀▄▀█ █▀▀ 　 ▀▀█▀▀ █▀▀█ 　 █░░░█ █▀▀█ █▀▀█ █▀▀ █░░█ █▀▀█ █░░█ █▀▀ █▀▀ 　 █▀▀█ █▀▀█ █▀▀█\s
                █▄█▄█ █▀▀ █░░ █░░ █░░█ █░▀░█ █▀▀ 　 ░░█░░ █░░█ 　 █▄█▄█ █▄▄█ █▄▄▀ █▀▀ █▀▀█ █░░█ █░░█ ▀▀█ █▀▀ 　 █▄▄█ █░░█ █░░█\s
                ░▀░▀░ ▀▀▀ ▀▀▀ ▀▀▀ ▀▀▀▀ ▀░░░▀ ▀▀▀ 　 ░░▀░░ ▀▀▀▀ 　 ░▀░▀░ ▀░░▀ ▀░▀▀ ▀▀▀ ▀░░▀ ▀▀▀▀ ░▀▀▀ ▀▀▀ ▀▀▀ 　 ▀░░▀ █▀▀▀ █▀▀▀""" + "\u001B[0m");
        applicationController.start();



        System.out.println(MaterialType.materialTypeCount());

//        WarehousesManagerController warehousesManagerController = new WarehousesManagerController();
//
//
//        Warehouse warehouse = new Warehouse("Goxt");
//        Warehouse warehouse1 = new Warehouse("Garni");
////
//        WarehouseController warehouseController = new WarehouseController();
////
//        warehousesManagerController.addWarehouse(warehousesManager, warehouse);
//        warehousesManagerController.addWarehouse(warehousesManager, warehouse1);
//
//        warehousesManagerController.showWarehousesList(warehousesManager.getWarehouses());

//        Material material1 = new Material(MaterialType.COPPER, "asdas", "aasdf", 150);
//        Material material2 = new Material(MaterialType.BOLT, "werwer", "sggf", 200);
//        Material material3 = new Material(MaterialType.IRON, "fhfg", "ggggg", 100);
//        Material material4 = new Material(MaterialType.IRON, "fhfg", "ggggg", 100);
//
//        //add
//        warehouseController.addMaterial(warehouse.getMaterials(), material1, 140);
////        warehouseController.addMaterial(warehouse.getMaterials(),material2,200);
////        warehouseController.addMaterial(warehouse.getMaterials(), material3,101);
////        warehouseController.addMaterial(warehouse.getMaterials(), material4,88);
//
//        warehouseController.addMaterial(warehouse1.getMaterials(), material2, 40);
//        warehouseController.addMaterial(warehouse1.getMaterials(), material2, 100);
//
//        //
//        System.out.println(warehouseController.getMaterialQuantity(warehouse.getMaterials(), material1));
//        System.out.println("---------------------------");
//        warehouseController.getWarehouseMaterials(warehouse.getMaterials());
//        System.out.println("---------------------------");
//        warehouseController.removeMaterial(warehouse.getMaterials(), material2);
//        System.out.println("---------------------------");
//        warehouseController.getWarehouseMaterials(warehouse.getMaterials());
//        System.out.println("---------------------------");
//        System.out.println("---------------------------");
//        //move
//        warehouseController.moveMaterial(warehousesManager, warehouse, warehouse1, material1, 100);
//
//        warehouseController.getWarehouseMaterials(warehouse1.getMaterials());
//        System.out.println("---------------------------");
//        System.out.println("---------------------------");
//        warehouseController.getWarehouseMaterials(warehouse.getMaterials());

    }
}
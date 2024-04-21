package org.example;


//import org.example.controller.ApplicationController;

import org.example.controller.MaterialController;
import org.example.controller.WarehouseCollectionController;
import org.example.controller.WarehouseController;
import org.example.model.Material;
import org.example.model.MaterialType;
import org.example.model.Warehouse;
import org.example.model.WarehouseCollection;

public class Main {
    public static void main(String[] args) {

        WarehouseCollectionController warehouseCollectionController = new WarehouseCollectionController();
        WarehouseController warehouseController = new WarehouseController();
        MaterialController materialController = new MaterialController();
        //----------------------------------------------------------------------------

        WarehouseCollection warehouseCollection = WarehouseCollection.INSTANCE;

        Warehouse autoParts = warehouseController.createWarehouse(null);
        Warehouse motoParts = warehouseController.createWarehouse("MotoParts");
        Warehouse someParts = warehouseController.createWarehouse("SomeParts");
        Warehouse nullWarehouse = null;
        //----------------------------------------------------------------------------
        Material iron = materialController.createMaterial(MaterialType.IRON, "Iron description", "Icon", 1600);
        Material bolt = materialController.createMaterial(MaterialType.BOLT, "Bolt description", "Icon", 2000);
        Material cooper = materialController.createMaterial(MaterialType.COPPER, "Bolt description", "Icon", 2000);
        Material nullMaterial = null;
        //----------------------------------------------------------------------------
        warehouseController.addMaterial(autoParts, iron, -1500);
        warehouseController.addMaterial(autoParts, bolt, 2000);
        warehouseController.printWarehouseMaterials(autoParts);
        System.out.println(warehouseController.getMaterialByType(autoParts, MaterialType.IRON));
        warehouseController.removeMaterial(autoParts, iron);
        //----------------------------------------------------------------------------
        warehouseCollectionController.addWarehouse(warehouseCollection, autoParts);
        warehouseCollectionController.addWarehouse(warehouseCollection, motoParts);
        System.out.println();

        warehouseController.moveMaterial(warehouseCollection, autoParts, motoParts, iron, 1000);

        System.out.println("autoPart : ");
        warehouseController.printWarehouseMaterials(autoParts);
        System.out.println();
        System.out.println("motoPart : ");
        warehouseController.printWarehouseMaterials(motoParts);
    }
}
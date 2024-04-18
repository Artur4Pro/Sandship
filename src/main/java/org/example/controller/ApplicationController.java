package org.example.controller;

import org.example.model.Material;
import org.example.model.MaterialType;
import org.example.model.Warehouse;
import org.example.model.WarehousesManager;
import org.example.service.ApplicationService;

public class ApplicationController {
    private final ApplicationService applicationService = new ApplicationService();
    private final WarehouseController warehouseController = new WarehouseController();
    private final WarehousesManager warehousesManager = WarehousesManager.INSTANCE;
    private final MaterialController materialController = new MaterialController();

    public void start(){
        applicationService.start();
    }




}

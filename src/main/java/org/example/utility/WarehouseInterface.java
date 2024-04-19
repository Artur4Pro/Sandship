package org.example.utility;

import org.example.model.Material;
import org.example.model.Warehouse;
import org.example.model.WarehousesManager;

import java.util.List;
import java.util.Map;

public interface WarehouseInterface {

    public void addWarehouse(WarehousesManager warehousesManager, Warehouse warehouse);

    public void showWarehousesList(WarehousesManager warehousesManager);
    public void showWarehousesListWithoutSelectedWarehouse(WarehousesManager warehousesManager,Warehouse warehouse);

    public Warehouse getWarehouse(WarehousesManager warehousesManager, int index);


}

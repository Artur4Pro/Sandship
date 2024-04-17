package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class WarehousesManager {
    private final List<Warehouse> warehouses = new ArrayList<>();

    private WarehousesManager() {
    }
    public static final WarehousesManager INSTANCE = new WarehousesManager();

    public List<Warehouse> getWarehouses() {
        return warehouses;
    }
}
package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class WarehouseCollection {

    private final List<Warehouse> warehouses = new ArrayList<>();

    private WarehouseCollection() {
    }
    public static final WarehouseCollection INSTANCE = new WarehouseCollection();

    public List<Warehouse> getWarehouses() {
        return warehouses;
    }
}
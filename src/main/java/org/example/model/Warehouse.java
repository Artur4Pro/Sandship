package org.example.model;

import java.util.*;

public class Warehouse {

    private String name;
    private final Map<Material, Integer> materials;

    public Warehouse(String name) {
        this.name = name;
        this.materials = new HashMap<>();
        }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Material, Integer> getMaterials() {
        return materials;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Warehouse warehouse = (Warehouse) o;
        return Objects.equals(name.toLowerCase(), warehouse.name.toLowerCase()) && Objects.equals(materials, warehouse.materials);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, materials);
    }
}

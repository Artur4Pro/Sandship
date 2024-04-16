package org.example.model;

import java.util.Objects;

public class Material {
    private MaterialType name;
    private String description;
    private String icon;
    private int maxCapacity;

    public Material(MaterialType name, String description, String icon, int maxCapacity) {
        this.name = name;
        this.description = description;
        this.icon = icon;
        this.maxCapacity = maxCapacity;
    }

    public MaterialType getName() {
        return name;
    }

    public void setName(MaterialType name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public long getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    @Override
    public String toString() {
        return "Material "+ name +
                ", description='" + description + '\'' +
                ", icon='" + icon + '\'' +
                ", maxCapacity=" + maxCapacity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Material material = (Material) o;
        return maxCapacity == material.maxCapacity && name == material.name && Objects.equals(description, material.description) && Objects.equals(icon, material.icon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, icon, maxCapacity);
    }
}

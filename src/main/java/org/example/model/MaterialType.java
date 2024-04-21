package org.example.model;

import java.util.ArrayList;
import java.util.List;

public enum MaterialType {

    IRON, COPPER, BOLT;

    private final static List<MaterialType> materialTypesList = new ArrayList<>();

    static {
        for (MaterialType type : MaterialType.values()) {
            materialTypesList.add(type);
        }
    }

    public static void printTypes() {
        for (MaterialType x : materialTypesList) {
            System.out.println((materialTypesList.indexOf(x) + 1) + " , " + x.name());
        }
    }

    public static MaterialType getType(int index) {
        return materialTypesList.get(index - 1);
    }

    public static int materialTypeCount() {
        return materialTypesList.size();
    }
}

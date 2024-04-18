package org.example.service;

import org.example.controller.MaterialController;
import org.example.controller.WarehouseController;
import org.example.model.Material;
import org.example.model.MaterialType;
import org.example.model.Warehouse;
import org.example.model.WarehousesManager;
import org.example.utility.ApplicationInterface;
import org.example.validators.Validators;

import java.util.Scanner;

public class ApplicationService implements ApplicationInterface {
    private final WarehousesManager warehousesManager = WarehousesManager.INSTANCE;
    private final WarehouseController warehouseController = new WarehouseController();
    private final MaterialController materialController = new MaterialController();
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String addName() {
        System.out.println("Write the name");
        return scanner.next();
    }

    @Override
    public String addDescription() {
        System.out.println("Write the description");
        return scanner.next();
    }

    @Override
    public String addIcon() {
        System.out.println("Give an icon");
        return scanner.next();
    }

    @Override
    public int addMaxQuantity() {
        System.out.println("Write the max quantity of Material");
        while (!scanner.hasNextInt()) {
            System.out.println("The entered is not number try again");
            scanner.next();
        }
        return scanner.nextInt();
    }

    @Override
    public int quantity(Material material) {
        System.out.println("Select the quantity of material");
        while (!scanner.hasNextInt()) {
            System.out.println("The entered is not number try again");
            scanner.next();
        }
        int quantity = scanner.nextInt();

        while (!Validators.isRightQuantity(material, quantity)) {
            System.out.println("Wrong quantity, enter around 0 to " + material.getMaxCapacity());
            quantity = scanner.nextInt();
        }
        return quantity;
    }

    @Override
    public void printName(String name) {
        System.out.println(name);
    }

    @Override
    public int enterNumber() {
        System.out.println("Select the number");
        while (!scanner.hasNextInt()) {
            System.out.println("The entered is not number try again");
            scanner.next();
        }
        return scanner.nextInt();
    }

    @Override
    public Material newMaterial() {
        return new Material(materialType(), addDescription(), addIcon(), addMaxQuantity());
    }

    @Override
    public Warehouse newWarehouse() {
        return new Warehouse(addName());
    }

    @Override
    public MaterialType materialType() {
        MaterialType.printTypes();
        System.out.print("For chose the material Type ");
        int x = enterNumber();
        if (x < 0 || x > MaterialType.materialTypeCount()) {
            System.out.println("You chose wrong number of material please chose again");
            return materialType();
        }
        return MaterialType.getType(x);
    }

    @Override
    public void start() {
        //Record.readRecord(contactsList);
        boolean on = true;
        while (on) {
            warehouseController.showWarehousesList(warehousesManager);
            System.out.println("""
                    1. Add warehouse 🔨
                    2. Chose warehouse 📖
                    3. Exit 🏁""");
            String stepOne = scanner.next();
            switch (stepOne) {
                case "1" -> warehouseController.addWarehouse(warehousesManager, newWarehouse());
                case "2" -> warehouseMenu();
                case "3" -> {
                    //Record.writeRecord(contactsList);
                    scanner.close();
                    //contactsList.exit();

                    System.out.println("\u001B[35m" + """
                            ╔╦╗┬ ┬┌─┐┌┐┌┬┌─┌─┐  ┌─┐┌┐┌┌┬┐  ╔═╗┌─┐┌─┐┌┬┐  ╔╗ ┬ ┬  ┬
                             ║ ├─┤├─┤│││├┴┐└─┐  ├─┤│││ ││  ║ ╦│ ││ │ ││  ╠╩╗└┬┘  │
                             ╩ ┴ ┴┴ ┴┘└┘┴ ┴└─┘  ┴ ┴┘└┘─┴┘  ╚═╝└─┘└─┘─┴┘  ╚═╝ ┴   o""" + "\u001B[0m");

                    on = false;
                }
                default -> {
                    System.err.println("\nWrong Input ! Try Again\n");
                }
            }
        }
    }

    @Override
    public void warehouseMenu() {
        boolean on = true;
        while (on) {
            if (warehousesManager.getWarehouses().isEmpty()) {
                start();
            }
            int size = warehousesManager.getWarehouses().size();

            warehouseController.showWarehousesList(warehousesManager);

            int selectedNumber = enterNumber();

            while (!Validators.isRightNumberInRange(selectedNumber, size)) {
                System.out.println("Wrong input number, try Again ");
                selectedNumber = enterNumber();
            }
            Warehouse warehouse = warehouseController.getWarehouse(warehousesManager, selectedNumber - 1);
            materialController.getWarehouseMaterials(warehouse);
            System.out.println("""
                    1. Add Material 🔨
                    2. Remove Material ✖️
                    3. Move Material 🚚
                    4. Back to last menu 🚚""");

            switch (scanner.next()) {
                case "1": {
                    Material material = newMaterial();
                    int quantity = quantity(material);
                    boolean isAdded = materialController.addMaterial(warehouse, material, quantity);
                    if (isAdded) {
                        materialController.addQuantity(warehouse, material, quantity);
                    }
                    break;
                }
                case "2": {
                    if (warehouse.getMaterials().isEmpty()) {
                        System.out.println("Warehouse is empty");
                        break;
                    }
                    System.out.println("For deleting chose the type ");
                    MaterialType materialType = materialType();
                    Material material = materialController.getMaterialByType(warehouse, materialType);
                    if (material == null) {
                        System.out.println("That material is not exist in Warehouse");
                        break;
                    }
                    materialController.removeMaterial(warehouse, material);
                    break;
                }
                case "3": {

                }
                case "4": {
                    start();
                    on = false;
                    break;
                }
                default: {
                    System.err.println("Wrong input please try again! \n");
                    warehouseMenu();
                }

            }
            warehouseMenu();
        }
    }
}



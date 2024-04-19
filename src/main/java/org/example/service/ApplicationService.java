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
        System.out.println("Write the name ");
        return scanner.next();
    }

    @Override
    public String addDescription() {
        System.out.println("Write the description ");
        return scanner.next();
    }

    @Override
    public String addIcon() {
        System.out.println("Give an icon ");
        return scanner.next();
    }

    @Override
    public int addMaxQuantity() {
        System.out.println("Write the max quantity of Material ");
        while (!scanner.hasNextInt()) {
            System.out.println("The entered is not number try again ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    @Override
    public int quantity(Material material) {
        System.out.println("Select the quantity of material ");
        while (!scanner.hasNextInt()) {
            System.out.println("The entered is not number try again ");
            scanner.next();
        }
        int quantity = scanner.nextInt();

        while (!Validators.isRightQuantity(material, quantity)) {
            System.out.println("Wrong quantity, enter around 0 to " + material.getMaxCapacity());
            return quantity(material);
        }
        return quantity;
    }

    @Override
    public void printName(String name) {
        System.out.println(name);
    }

    @Override
    public int enterNumber() {
        System.out.println("Select the number ");
        while (!scanner.hasNextInt()) {
            System.out.println("The entered is not number try again ");
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
            System.out.println("You chose wrong number of material please chose again ");
            return materialType();
        }
        return MaterialType.getType(x);
    }

    @Override
    public void startPage() {
        //Record.readRecord(contactsList);
        boolean on = true;
        while (on) {
            warehouseController.showWarehousesList(warehousesManager);

            System.out.println();
            startMenu();

            String stepOne = scanner.next();
            switch (stepOne) {
                case "1" -> warehouseController.addWarehouse(warehousesManager, newWarehouse());
                case "2" -> warehousePage();
                case "3" -> {
                    //Record.writeRecord(contactsList);
                    scanner.close();
                    //contactsList.exit();
                    goodBy();
                    on = false;
                    System.exit(0);
                }
                default -> {
                    System.out.println("\nWrong Input ! Try Again\n");
                }
            }
        }
    }





    @Override
    public void warehousePage() {
        boolean on = true;
        while (on) {
            if (warehousesManager.getWarehouses().isEmpty()) {
                startPage();
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

            warehouseMenu();

            switch (scanner.next()) {
                case "1": {
                    Material material = newMaterial();
                    int quantity = quantity(material);
                    materialController.addMaterial(warehouse, material, quantity);
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
                    if (!(warehousesManager.getWarehouses().size() > 1)) {
                        System.out.println("You need more than 1 Warehouse for using this method ");
                        warehousePage();
                    }
                    if (warehouse.getMaterials().isEmpty()) {
                        System.out.println("Warehouse is empty");
                        break;
                    }

                    warehouseController.showWarehousesListWithoutSelectedWarehouse(warehousesManager, warehouse);
                    int toMoveWarehouseNumber = enterNumber();
                    while (toMoveWarehouseNumber > warehousesManager.getWarehouses().size() || toMoveWarehouseNumber < 1) {
                        System.out.println("Enter from exist list");
                        toMoveWarehouseNumber = enterNumber();
                    }

                    if (warehouse.getMaterials().isEmpty()) {
                        System.out.println("Warehouse is empty");
                        break;
                    }
                    Warehouse warehouseTo = warehouseController.getWarehouse(warehousesManager, toMoveWarehouseNumber - 1);

                    materialController.getWarehouseMaterials(warehouse);

                    System.out.println("Chose the Material what you want to move");
                    MaterialType materialType = materialType();

                    Material material = materialController.getMaterialByType(warehouse, materialType);
                    if (material == null) {
                        System.out.println("That material is not exist in Warehouse");
                        break;
                    }

                    System.out.print("Enter the quantity for moving , ");
                    int quantityToMove = quantity(material);
                    materialController.moveMaterial(warehousesManager, warehouse, warehouseTo, material, quantityToMove);

                }
                case "4": {
                    startPage();
                    on = false;
                    break;
                }
                default: {
                    System.out.println("Wrong input please try again! \n");
                    warehousePage();
                }
            }
        }
    }

    @Override
    public void startMenu() {
        System.out.println("""
                    1. Add warehouse 🔨
                    2. Chose warehouse 📖
                    3. Exit 🏁""");
    }

    @Override
    public void warehouseMenu() {
        System.out.println("""
                    1. Add Material 🔨
                    2. Remove Material ✖️
                    3. Move Material 🚚
                    4. Back to last menu ↩️""");
    }

    @Override
    public void greeting() {
        System.out.println("\u001B[35m" + """
                ┏┓┏┓┏┓━━━━┏┓━━━━━━━━━━━━━━━━━━━━━━┏┓━━━━━━━━━┏┓┏┓┏┓━━━━━━━━━━━━┏┓━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
                ┃┃┃┃┃┃━━━━┃┃━━━━━━━━━━━━━━━━━━━━━┏┛┗┓━━━━━━━━┃┃┃┃┃┃━━━━━━━━━━━━┃┃━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
                ┃┃┃┃┃┃┏━━┓┃┃━┏━━┓┏━━┓┏┓┏┓┏━━┓━━━━┗┓┏┛┏━━┓━━━━┃┃┃┃┃┃┏━━┓━┏━┓┏━━┓┃┗━┓┏━━┓┏┓┏┓┏━━┓┏━━┓━━━━┏━━┓━┏━━┓┏━━┓
                ┃┗┛┗┛┃┃┏┓┃┃┃━┃┏━┛┃┏┓┃┃┗┛┃┃┏┓┃━━━━━┃┃━┃┏┓┃━━━━┃┗┛┗┛┃┗━┓┃━┃┏┛┃┏┓┃┃┏┓┃┃┏┓┃┃┃┃┃┃━━┫┃┏┓┃━━━━┗━┓┃━┃┏┓┃┃┏┓┃
                ┗┓┏┓┏┛┃┃━┫┃┗┓┃┗━┓┃┗┛┃┃┃┃┃┃┃━┫━━━━━┃┗┓┃┗┛┃━━━━┗┓┏┓┏┛┃┗┛┗┓┃┃━┃┃━┫┃┃┃┃┃┗┛┃┃┗┛┃┣━━┃┃┃━┫━━━━┃┗┛┗┓┃┗┛┃┃┗┛┃
                ━┗┛┗┛━┗━━┛┗━┛┗━━┛┗━━┛┗┻┻┛┗━━┛━━━━━┗━┛┗━━┛━━━━━┗┛┗┛━┗━━━┛┗┛━┗━━┛┗┛┗┛┗━━┛┗━━┛┗━━┛┗━━┛━━━━┗━━━┛┃┏━┛┃┏━┛
                ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┃┃━━┃┃━━
                ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┗┛━━┗┛━━""" + "\u001B[0m");
    }

    @Override
    public void goodBy() {
        System.out.println("\u001B[35m" + """
                ┏━━━━┓┏┓━━━━━━━━━━━┏┓━━━━━━━━━━━━━━━━━━━━━┏┓━━━━━━━━━━━━━━━━━━┏┓━━━━┏┓━━━━━━━
                ┃┏┓┏┓┃┃┃━━━━━━━━━━━┃┃━━━━━━━━━━━━━━━━━━━━━┃┃━━━━━━━━━━━━━━━━━━┃┃━━━━┃┃━━━━━━━
                ┗┛┃┃┗┛┃┗━┓┏━━┓━┏━┓━┃┃┏┓┏━━┓━━━━┏━━┓━┏━┓━┏━┛┃━━━━┏━━┓┏━━┓┏━━┓┏━┛┃━━━━┃┗━┓┏┓━┏┓
                ━━┃┃━━┃┏┓┃┗━┓┃━┃┏┓┓┃┗┛┛┃━━┫━━━━┗━┓┃━┃┏┓┓┃┏┓┃━━━━┃┏┓┃┃┏┓┃┃┏┓┃┃┏┓┃━━━━┃┏┓┃┃┃━┃┃
                ━┏┛┗┓━┃┃┃┃┃┗┛┗┓┃┃┃┃┃┏┓┓┣━━┃━━━━┃┗┛┗┓┃┃┃┃┃┗┛┃━━━━┃┗┛┃┃┗┛┃┃┗┛┃┃┗┛┃━━━━┃┗┛┃┃┗━┛┃
                ━┗━━┛━┗┛┗┛┗━━━┛┗┛┗┛┗┛┗┛┗━━┛━━━━┗━━━┛┗┛┗┛┗━━┛━━━━┗━┓┃┗━━┛┗━━┛┗━━┛━━━━┗━━┛┗━┓┏┛
                ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┏━┛┃━━━━━━━━━━━━━━━━━━━━┏━┛┃━
                ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┗━━┛━━━━━━━━━━━━━━━━━━━━┗━━┛━""" + "\u001B[0m");
        System.exit(0);
    }


}



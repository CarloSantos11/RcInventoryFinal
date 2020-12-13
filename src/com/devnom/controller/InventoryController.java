package com.devnom.controller;

import com.devnom.model.Inventory;
import com.devnom.model.Shell;
import com.devnom.view.InventoryUi;

import java.util.ArrayList;
import java.util.Scanner;

public class InventoryController {
    // bootUp
    // this method should prompt the first menu and keep the program running as long as we don't press qu

    private static Inventory currentInventory = new Inventory();

    public static void bootUp() {
        String userInput = "";

        while (!userInput.equalsIgnoreCase("Q")){
            InventoryUi.openingMenu();
            userInput = getUserInput();
            userInput =  inventoryActions(userInput);
        }
    }

    // May add these into the controller directory as well
    public static String getUserInput(){
        Scanner userInput = new Scanner(System.in);
        return userInput.next();
    }

    public static String inventoryActions(String choice) {
        switch (choice){
            case "1":
                choice = "1";
                addToInventory();
                break;
            case "2":
                checkInventory();
                choice = "2";
                break;
            case "3":
                packageBox();
                choice = "3";
                break;
            default:
                choice = "Q";
        }
        return choice;
    }

    // Possibly move these methods to a controller class because they are actions
    // being performed on our POJOs
    // some mvc reading: https://stackoverflow.com/questions/1015813/what-goes-into-the-controller-in-mvc
    public static void addToInventory() {
        InventoryUi.optionAddToInventory();
        int choice = Integer.parseInt(getUserInput());
        InventoryUi.countPrompt();
        int count = Integer.parseInt(getUserInput());
        boolean validInput = true;
        while (validInput) {
            switch (choice) {
                case 1:
                    InventoryUi.shellTypePrompt();
                    String bodyShellType = getUserInput();
                    bodyShellType = bodyShellType.toLowerCase();
                    ArrayList<?> shell = Shell.shellTypes;
                    if (shell.contains(bodyShellType)) {
                        if (shell.equals("military") || shell.equals("trucks")) {
                            validInput = currentInventory.addBodyShell(count, bodyShellType, 20);
                        } else {
                            validInput = currentInventory.addBodyShell(count, bodyShellType);
                        }
                    } else {
                        while (!shell.contains(bodyShellType)) {
                            InventoryUi.wrongShellTypePrompt();
                            bodyShellType = getUserInput();
                        }
                    }
                    break;
                case 2:
                    validInput = currentInventory.addChargers(count);
                    break;
                case 3:
                    validInput = currentInventory.addMotors(count);
                    break;
                case 4:
                    validInput = currentInventory.addShocks(count);
                    break;
                case 5:
                    InventoryUi.wheelTypePrompt();
                    int price = 30;
                    boolean isWide = getUserInput().equalsIgnoreCase("Y") ? true : false;
                    validInput = currentInventory.addWheels(count, isWide, price);
                    break;
                case 6:
                    validInput = currentInventory.addRemoteControllers(count);
                    break;
                case 7:
                    validInput = currentInventory.addFrame(count);
                    break;
                case 8:
                    validInput = currentInventory.addBatteries(count);
                    break;
            }
            if (!validInput){
                System.out.println("Invalid Input");
            }
        }
    }


    public static void checkInventory() {
        System.out.println("this will check how many of each item we have");
    }
    public static void packageBox() {
        System.out.println("This will package our box and decrement loose inventory items");
    }
}

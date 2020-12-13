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

        InventoryUi.availableItemsPrompt("Add");
        boolean correctInput = false;
        int choice = Integer.parseInt(getUserInput());

        while(!correctInput) {
            if (choice > 0 && choice < 9) {
                correctInput = true;
            } else {
                InventoryUi.invalidInputPrompt("Input");
                choice = Integer.parseInt(getUserInput());
            }
        }

        InventoryUi.countPrompt();
        int count = Integer.parseInt(getUserInput());
        boolean validInput = false;//as the addItems()methods return a boolean if there's a problem adding, this checks for the invalid inputs

        while (!validInput) {
            if (count < 0) {
                InventoryUi.invalidInputPrompt("count");
                InventoryUi.countPrompt();
                count = Integer.parseInt(getUserInput());
            } else validInput = true;
        }

        switch (choice) {
            case 1:
                InventoryUi.shellTypePrompt();
                String bodyShellType = getUserInput();
                bodyShellType = bodyShellType.toLowerCase();
                ArrayList<?> shell = Shell.shellTypes;
                if (shell.contains(bodyShellType)) {
                    if (shell.equals("military") || shell.equals("trucks")) {
                        currentInventory.addBodyShell(count, bodyShellType, 20);
                    } else {
                        currentInventory.addBodyShell(count, bodyShellType);
                    }
                } else {
                    while (!shell.contains(bodyShellType)) {
                        InventoryUi.invalidInputPrompt("Shell type");
                        InventoryUi.shellTypePrompt();
                        bodyShellType = getUserInput().toLowerCase();
                    }
                }
                break;
            case 2:
                currentInventory.addChargers(count);
                break;
            case 3:
                currentInventory.addMotors(count);
                break;
            case 4:
                currentInventory.addShocks(count);
                break;
            case 5:
                InventoryUi.wheelTypePrompt();
                int price = 30;
                boolean isWide = getUserInput().equalsIgnoreCase("Y") ? true : false;
                currentInventory.addWheels(count, isWide, price);
                break;
            case 6:
                currentInventory.addRemoteControllers(count);
                break;
            case 7:
                currentInventory.addFrame(count);
                break;
            case 8:
                currentInventory.addBatteries(count);
                break;
        }
        InventoryUi.successfulMessagePrompt();


    }


    public static void checkInventory() {//this checks how many items we have
        InventoryUi.availableItemsPrompt("Check  Count");
        boolean correctInput = false;
        int choice = Integer.parseInt(getUserInput());

        while(!correctInput) {
            if (choice > 0 && choice < 9) {
                correctInput = true;
            } else {
                InventoryUi.invalidInputPrompt("Input");
                choice = Integer.parseInt(getUserInput());
            }
        }

        switch (choice) {
            case 1:
                InventoryUi.getCountPrompt("Body Shell", currentInventory.getBodyShellsCount());
                break;
            case 2:
                InventoryUi.getCountPrompt("Charger",currentInventory.getChargersCount());
                break;
            case 3:
                InventoryUi.getCountPrompt("Motor",currentInventory.getMotorsCount());
                break;
            case 4:
                InventoryUi.getCountPrompt("Shocks",currentInventory.getShocksCount());
                break;
            case 5:
                InventoryUi.getCountPrompt("Wheels" ,currentInventory.getWheelsCount());
                break;
            case 6:
                InventoryUi.getCountPrompt("Controller",currentInventory.getRemoteControllerCount());
                break;
            case 7:
                InventoryUi.getCountPrompt("Frame" ,currentInventory.getFrameCount());
                break;
            case 8:
                InventoryUi.getCountPrompt("Battery",currentInventory.getBatteryCount());
                break;
        }


    }
    public static void packageBox() {
        System.out.println("This will package our box and decrement loose inventory items");
    }
}

package com.devnom.controller;

import com.devnom.view.InventoryUi;

import java.util.Scanner;

public class InventoryController {

    // bootUp
    // this method should prompt the first menu and keep the program running as long as we don't press quit
    public static void bootUp() {
        String userInput = "";

        while (!userInput.equalsIgnoreCase("Q")){
            InventoryUi.promptOpeningMenu();
            userInput = inventoryActions(getUserInput());
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

    public static double getQuantityAction(String choice) {
        double quantity = 0.0;

        InventoryUi.promptItemQuantity(choice);
        return quantity;
    }

    // Possibly move these methods to a controller class because they are actions
    // being performed on our POJOs
    // some mvc reading: https://stackoverflow.com/questions/1015813/what-goes-into-the-controller-in-mvc
    public static void addToInventory() {
        InventoryUi.promptAddToInventory();
        getUserInput();
        getQuantityAction(getUserInput());
    }

    public static void checkInventory() {
        System.out.println("this will check how many of each item we have");
    }

    public static void packageBox() {
        System.out.println("This will package our box and decrement loose inventory items");
    }
}

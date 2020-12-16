package com.devnom.controller;

import com.devnom.model.BodyShellTypes;
import com.devnom.model.Inventory;
import com.devnom.model.Shell;
import com.devnom.view.InventoryUi;

import java.util.ArrayList;
import java.util.Scanner;

public class InventoryController {
    // bootUp
    // this method should prompt the first menu and keep the program running as long as we don't press qu

    private static final Inventory currentInventory = new Inventory();

    public static void bootUp() {
        String userInput = "";

        while (!userInput.equalsIgnoreCase("Q")){
            InventoryUi.openingMenu();
            userInput = getUserInput();
            userInput =  inventoryActions(userInput);
        }
    }

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
                removeItems();
                choice = "3";
                break;
            case "4":
                packageBox();
                choice = "4";
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

        InventoryUi.countPrompt("Add");
        int count = Integer.parseInt(getUserInput());
        boolean validInput = false;//as the addItems()methods return a boolean if there's a problem adding, this checks for the invalid inputs

        while (!validInput) {
            if (count < 0) {
                InventoryUi.invalidInputPrompt("count");
                InventoryUi.countPrompt("Add");
                count = Integer.parseInt(getUserInput());
            } else validInput = true;
        }

        switch (choice) {
            case 1:
                InventoryUi.shellTypePrompt();
                String bodyShellType = getUserInput();
                bodyShellType = bodyShellType.toLowerCase();
                ArrayList<String> shell = Shell.shellTypes;
                if (shell.contains(bodyShellType)) {
                    if (shell.contains("military") || shell.contains("trucks")) {
                        currentInventory.addBodyShell(count, bodyShellType, 200);
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
                String wheelType = getUserInput().toLowerCase();

                int price = 30;
                boolean isWide = false;

                boolean validWheelType = false;
                while(!validWheelType) {
                    if (wheelType.equals("y")||wheelType.equals("n")){
                        validWheelType = true;
                        isWide = wheelType.equals("y");
                    }else {
                        InventoryUi.invalidInputPrompt("Wheel Type");
                        wheelType = getUserInput().toLowerCase();
                    }
                }
                currentInventory.addWheels(count,isWide, price);
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
                InventoryUi.subItemCountPrompt("Sport", BodyShellTypes.Sport.getCount());
                InventoryUi.subItemCountPrompt("Classic", BodyShellTypes.Classic.getCount());
                InventoryUi.subItemCountPrompt("Crawlers", BodyShellTypes.Crawlers.getCount());
                InventoryUi.subItemCountPrompt("ATV", BodyShellTypes.ATV.getCount());
                InventoryUi.subItemCountPrompt("Dune Buggy", BodyShellTypes.DuneBuggy.getCount());
                InventoryUi.subItemCountPrompt("SUV", BodyShellTypes.SUV.getCount());
                InventoryUi.subItemCountPrompt("Military", BodyShellTypes.Military.getCount());
                InventoryUi.subItemCountPrompt("Trucks", BodyShellTypes.Trucks.getCount());
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
                InventoryUi.subItemCountPrompt("Wide Wheels", currentInventory.getWideWheelsCount());
                InventoryUi.subItemCountPrompt("Normal Wheels", currentInventory.getNormalWheelsCount());
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

        //Choosing the Car Type
        InventoryUi.carTypePrompt();
        boolean isStreet;
        int choice = Integer.parseInt(getUserInput());
        boolean validInput=false;
        while (!validInput) {
            if (choice>2||choice<1){
                InventoryUi.invalidInputPrompt("Input");
                choice = Integer.parseInt(getUserInput());
            }else {
                validInput= true;
            }
        }
        String carType;
        if (choice==1) {
            carType = "Off-Road";
            isStreet = false;
        }else {
            carType = "Street";
            isStreet =true;
        }


        //Choosing a Body Shell
        String bodyShellType;
        InventoryUi.shellChoosingPrompt(carType);
        choice = Integer.parseInt(getUserInput());
        validInput=false;
        while (!validInput) {
            if (choice>5||choice<1){
                InventoryUi.invalidInputPrompt("Input");
                choice = Integer.parseInt(getUserInput());
            }else {
                validInput= true;
            }
        }
        if(!isStreet){
            bodyShellType = InventoryUi.shellTypes.get(choice-1);
        }
        else {
            bodyShellType = InventoryUi.shellTypes.get(choice+2);
        }
        validate(currentInventory.removeBodyShell(1,bodyShellType),"Body Shell");

        //Choosing a Wheel Type
        if (!isStreet){
            InventoryUi.wheelTypePrompt();

            boolean isWide;
            String wheelType = getUserInput().toLowerCase();

            boolean validWheelType = false;
            while(!validWheelType) {
                if (wheelType.equals("y")||wheelType.equals("n")){
                    validWheelType = true;
                    isWide = wheelType.equals("y");
                    validate(currentInventory.removeWheels(1,isWide),"Wheels");
                }else {
                    InventoryUi.invalidInputPrompt("Wheel Type");
                    wheelType = getUserInput().toLowerCase();
                }
            }
        } else {
            validate(currentInventory.removeWheels(1,false),"Wheels");
        }

        //removing all other items
        validate(currentInventory.removeBatteries(1),"Batteries");
        validate(currentInventory.removeChargers(1),"Chargers");
        validate(currentInventory.removeFrame(1),"Frame");
        validate(currentInventory.removeMotors(1),"Motors");
        validate(currentInventory.removeRemoteControllers(1),"Remote Controller");
        validate(currentInventory.removeShocks(1),"Shocks");

        InventoryUi.successfulMessagePrompt();


    }

    public static void removeItems(){
        InventoryUi.availableItemsPrompt("Remove");
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

        InventoryUi.countPrompt("Remove");
        int count = Integer.parseInt(getUserInput());
        boolean validInput = false;
        while (!validInput) {
            if (count < 0) {
                InventoryUi.invalidInputPrompt("count");
                InventoryUi.countPrompt("Remove");
                count = Integer.parseInt(getUserInput());
            } else validInput = true;
        }

        switch (choice) {
            case 1:
                InventoryUi.shellTypePrompt();
                String bodyShellType = getUserInput();
                bodyShellType = bodyShellType.toLowerCase();
                ArrayList<String> shell = Shell.shellTypes;
                if (shell.contains(bodyShellType)) {
                        validate(currentInventory.removeBodyShell(count,bodyShellType),"Shell");
                } else {
                    while (!shell.contains(bodyShellType)) {
                        InventoryUi.invalidInputPrompt("Shell type");
                        InventoryUi.shellTypePrompt();
                        bodyShellType = getUserInput().toLowerCase();
                    }
                }
                break;
            case 2:
                validate(currentInventory.removeChargers(count),"Charger");
                break;
            case 3:
                validate(currentInventory.removeMotors(count),"Motor");
                break;
            case 4:
                validate(currentInventory.removeShocks(count),"Shocks");
                break;
            case 5:
                InventoryUi.wheelTypePrompt();
                String wheelType = getUserInput().toLowerCase();

                boolean isWide = false;

                boolean validWheelType = false;
                while(!validWheelType) {
                    if (wheelType.equals("y")||wheelType.equals("n")){
                        validWheelType = true;
                        isWide = wheelType.equals("y");
                    }else {
                        InventoryUi.invalidInputPrompt("Wheel Type");
                        wheelType = getUserInput().toLowerCase();
                    }
                }
                validate(currentInventory.removeWheels(count,isWide),"Wheels");
                break;
            case 6:
                validate(currentInventory.removeRemoteControllers(count),"Remote Controller");
                break;
            case 7:
                validate(currentInventory.removeFrame(count),"Frame");
                break;
            case 8:
                validate(currentInventory.removeBatteries(count),"Battery");
                break;
        }
        InventoryUi.successfulMessagePrompt();

    }

    protected static void validate(boolean valid,String item){
        if (!valid){
            InventoryUi.notEnoughCountPrompt(item);
        }
    }
}

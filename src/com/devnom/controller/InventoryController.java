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
        int choice = Integer.parseInt(getUserInput());

        choice = validateInput(1,8,choice,"Input");

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
        InventoryUi.availableItemsPrompt("Check Count");
        int choice = Integer.parseInt(getUserInput());

        choice = validateInput(1,8,choice,"Input");

        switch (choice) {
            case 1:
                InventoryUi.getCountPrompt("Body Shell", currentInventory.getBodyShellsCount());
                InventoryUi.subItemCountPrompt("Sport", currentInventory.getBodyShellsCount("sport"));
                InventoryUi.subItemCountPrompt("Classic", currentInventory.getBodyShellsCount("classic"));
                InventoryUi.subItemCountPrompt("Crawlers", currentInventory.getBodyShellsCount("crawlers"));
                InventoryUi.subItemCountPrompt("ATV", currentInventory.getBodyShellsCount("atv"));
                InventoryUi.subItemCountPrompt("Dune Buggy", currentInventory.getBodyShellsCount("dune buggy"));
                InventoryUi.subItemCountPrompt("SUV", currentInventory.getBodyShellsCount("suv"));
                InventoryUi.subItemCountPrompt("Military",currentInventory.getBodyShellsCount("military"));
                InventoryUi.subItemCountPrompt("Trucks", currentInventory.getBodyShellsCount("trucks"));
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
                InventoryUi.subItemCountPrompt("Wide Wheels", currentInventory.getWheelsCount(true));
                InventoryUi.subItemCountPrompt("Normal Wheels", currentInventory.getWheelsCount(false));
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
        boolean isOffRoad;
        int choice = Integer.parseInt(getUserInput());
        choice = validateInput(1,2,choice,"Input");
        String carType;
        if (choice==1) {
            carType = "Off-Road";
            isOffRoad = true;
        }else {
            carType = "Street";
            isOffRoad =false;
        }


        //Choosing a Body Shell
        String bodyShellType;
        InventoryUi.shellChoosingPrompt(carType);
        choice = Integer.parseInt(getUserInput());
        choice = validateInput(1,5,choice,"Input");
        if(isOffRoad){
            if (choice<4) {
                bodyShellType = InventoryUi.shellTypes.get(choice - 1);
            }else  {
                bodyShellType = InventoryUi.shellTypes.get(choice +2);
            }
        }
        else {
            bodyShellType = InventoryUi.shellTypes.get(choice+2);
        }
        validateInput(1,currentInventory.getBodyShellsCount(),1,"Body Shell");
        currentInventory.removeBodyShell(1,bodyShellType);

        //Choosing a Wheel Type
        if (isOffRoad){
            InventoryUi.wheelTypePrompt();

            boolean isWide;
            String wheelType = getUserInput().toLowerCase();

            boolean validWheelType = false;
            while(!validWheelType) {
                if (wheelType.equals("y")||wheelType.equals("n")){
                    validWheelType = true;
                    isWide = wheelType.equals("y");
                    validateInput(1,currentInventory.getWheelsCount(isWide),1,"Count");
                    currentInventory.removeWheels(1,isWide);
                }else {
                    InventoryUi.invalidInputPrompt("Wheel Type");
                    wheelType = getUserInput().toLowerCase();
                }
            }
        } else {
            validateInput(1,currentInventory.getWheelsCount(false),1,"Count");
            currentInventory.removeWheels(1,false);
        }

        //removing all other items

        validateInput(1,currentInventory.getBatteryCount(),1,"Count");
        currentInventory.removeBatteries(1);
        validateInput(1,currentInventory.getChargersCount(),1,"Count");
        currentInventory.removeChargers(1);
        validateInput(1,currentInventory.getFrameCount(),1,"Count");
        currentInventory.removeFrame(1);
        validateInput(1,currentInventory.getMotorsCount(),1,"Count");
        currentInventory.removeMotors(1);
        validateInput(1,currentInventory.getRemoteControllerCount(),1,"Count");
        currentInventory.removeRemoteControllers(1);
        validateInput(1,currentInventory.getShocksCount(),1,"Count");
        currentInventory.removeShocks(1);

        InventoryUi.successfulMessagePrompt();


    }

    public static void removeItems(){
        InventoryUi.availableItemsPrompt("Remove");
        int choice = Integer.parseInt(getUserInput());

        choice = validateInput(1,8,choice,"Input");

        InventoryUi.countPrompt("Remove");
        int count = Integer.parseInt(getUserInput());
        count = validateInput(1, Integer.MAX_VALUE,count,"Count");

        switch (choice) {
            case 1:
                InventoryUi.shellTypePrompt();
                String bodyShellType = getUserInput();
                bodyShellType = bodyShellType.toLowerCase();
                ArrayList<String> shell = Shell.shellTypes;
                if (shell.contains(bodyShellType)) {
                    count = validateInput(1, currentInventory.getBodyShellsCount(bodyShellType),count,"Count");
                    currentInventory.removeBodyShell(count,bodyShellType);
                } else {
                    while (!shell.contains(bodyShellType)) {
                        InventoryUi.invalidInputPrompt("Shell type");
                        InventoryUi.shellTypePrompt();
                        bodyShellType = getUserInput().toLowerCase();
                    }
                }
                break;
            case 2:
                count = validateInput(1,currentInventory.getChargersCount(),count,"Chargers");
                currentInventory.removeChargers(count);
                break;
            case 3:
                count = validateInput(1, currentInventory.getMotorsCount(),count,"Count");
                currentInventory.removeMotors(count);
                break;
            case 4:
                count = validateInput(1, currentInventory.getShocksCount(),count,"Shocks");
                currentInventory.removeShocks(count);
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
                count = validateInput(1, currentInventory.getWheelsCount(isWide),count,"Count");
                currentInventory.removeWheels(count,isWide);
                break;
            case 6:
                count = validateInput(1, currentInventory.getRemoteControllerCount(),count,"Count");
                currentInventory.removeRemoteControllers(count);
                break;
            case 7:
                count = validateInput(1, currentInventory.getFrameCount(),count,"Count");
                currentInventory.removeFrame(count);
                break;
            case 8:
                count = validateInput(1, currentInventory.getBatteryCount(),count,"Count");
                currentInventory.removeBatteries(count);
                break;
        }
        InventoryUi.successfulMessagePrompt();

    }

    private static int validateInput(int lowerLimit, int upperLimit,int input,String whatIsWrong){
        boolean validInput = false;
        while (!validInput) {
            if (input < lowerLimit || input > upperLimit) {
                InventoryUi.invalidInputPrompt(whatIsWrong);
                return input = Integer.parseInt(getUserInput());
            } else validInput = true;
        }
        return input;
    }
}

package com.devnom.controller;

import com.devnom.model.Inventory;
import com.devnom.model.Shell;
import com.devnom.view.InventoryUi;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InventoryController {
    // bootUp
    // this method should prompt the first menu and keep the program running as long as we don't press qu

    private static final Inventory currentInventory = new Inventory();

    public static void bootUp() {
        String userInput = "";

        while (!userInput.equalsIgnoreCase("Q")){
            InventoryUi.openingMenu();
            userInput = getUserInputString();
            userInput =  inventoryActions(userInput);
        }
    }

    private static String getUserInputString(){
        Scanner userInput = new Scanner(System.in);
        return userInput.next();
    }

    private static int getUserInputInt() {
        Scanner userInput = new Scanner(System.in);
        boolean valid= false;
        int input = -1;
        do {
            try {
                input = userInput.nextInt();
                valid = true;
            } catch (InputMismatchException e) {
                userInput.next();
                InventoryUi.invalidInputPrompt("Choice");
            }
        }while (!valid);
        return input;

    }

    private static String inventoryActions(String choice) {
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
                buildCar();
                choice = "4";
                break;
            case "Q":
                choice="Q";
                break;
            default:
                InventoryUi.invalidInputPrompt("Choice");
        }
        return choice;
    }

    // Possibly move these methods to a controller class because they are actions
    // being performed on our POJOs
    // some mvc reading: https://stackoverflow.com/questions/1015813/what-goes-into-the-controller-in-mvc

    private static void addToInventory() {

        InventoryUi.availableItemsPrompt("Add");
        int choice = getUserInputInt();

        choice = validateInput(8,choice,"Input");

        InventoryUi.countPrompt("Add");
        int count = getUserInputInt();
        boolean validInput = false;//as the addItems()methods return a boolean if there's a problem adding, this checks for the invalid inputs

        while (!validInput) {
            if (count < 0) {
                InventoryUi.invalidInputPrompt("count");
                InventoryUi.countPrompt("Add");
                count = getUserInputInt();
            } else validInput = true;
        }

        switch (choice) {
            case 1:
                InventoryUi.shellTypePrompt();
                int bodyShellChoice = getUserInputInt();
                String bodyShellType="";
                bodyShellChoice = validateInput(Shell.shellTypes.size(),bodyShellChoice,"Shell Type");
                for (int i = 1;i <= Shell.shellTypes.size();i++){
                    if (i == bodyShellChoice){
                        bodyShellType = Shell.shellTypes.get(i-1);
                    }
                }
                currentInventory.addBodyShell(count,bodyShellType);
                InventoryUi.successfulAdditionPrompt(count,"Body Shell - "+ bodyShellType);
                break;
            case 2:
                currentInventory.addChargers(count);
                InventoryUi.successfulAdditionPrompt(count,"Chargers");
                break;
            case 3:
                currentInventory.addMotors(count);
                InventoryUi.successfulAdditionPrompt(count,"Motor");
                break;
            case 4:
                currentInventory.addShocks(count);
                InventoryUi.successfulAdditionPrompt(count,"Shocks");
                break;
            case 5:
                InventoryUi.wheelTypePrompt();
                String wheelType = getUserInputString().toLowerCase();

                int price = 30;
                boolean isWide = false;

                boolean validWheelType = false;
                while(!validWheelType) {
                    if (wheelType.equals("y")||wheelType.equals("n")){
                        validWheelType = true;
                        isWide = wheelType.equals("y");
                    }else {
                        InventoryUi.invalidInputPrompt("Wheel Type");
                        wheelType = getUserInputString().toLowerCase();
                    }
                }
                currentInventory.addWheels(count,isWide, price);
                InventoryUi.successfulAdditionPrompt(count,"Wheels - "+ (isWide ? "Wide":"Normal"));
                break;
            case 6:
                currentInventory.addRemoteControllers(count);
                InventoryUi.successfulAdditionPrompt(count,"Remote Controller");
                break;
            case 7:
                currentInventory.addFrame(count);
                InventoryUi.successfulAdditionPrompt(count,"Frame");
                break;
            case 8:
                currentInventory.addBatteries(count);
                InventoryUi.successfulAdditionPrompt(count,"Batteries");
                break;
        }


    }

    private static void checkInventory() {//this checks how many items we have
        InventoryUi.availableItemsPrompt("Check Count");
        int choice = getUserInputInt();

        choice = validateInput(8,choice,"Choice");

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

    private static void removeItems(){
        InventoryUi.availableItemsPrompt("Remove");
        int choice = getUserInputInt();

        choice = validateInput(8,choice,"Choice");

        InventoryUi.countPrompt("Remove");
        int count = getUserInputInt();
        count = validateInput(Integer.MAX_VALUE,count,"Count");

        switch (choice) {
            case 1:
                InventoryUi.shellTypePrompt();
                int bodyShellChoice = getUserInputInt();
                String bodyShellType="";
                bodyShellChoice = validateInput(Shell.shellTypes.size(),bodyShellChoice,"Shell Type");
                for (int i = 1;i <= Shell.shellTypes.size();i++){
                    if (i == bodyShellChoice){
                        bodyShellType = Shell.shellTypes.get(i-1);
                    }
                }
                count = validateCount(currentInventory.getBodyShellsCount(bodyShellType),count,"Body Shell - " +bodyShellType);
                currentInventory.removeBodyShell(count,bodyShellType);
                break;
            case 2:
                count = validateCount(currentInventory.getChargersCount(),count,"Chargers Count");
                currentInventory.removeChargers(count);
                break;
            case 3:
                count = validateCount(currentInventory.getMotorsCount(),count,"Count Count");
                currentInventory.removeMotors(count);
                break;
            case 4:
                count = validateCount(currentInventory.getShocksCount(),count,"Shocks Count");
                currentInventory.removeShocks(count);
                break;
            case 5:
                InventoryUi.wheelTypePrompt();
                String wheelType = getUserInputString().toLowerCase();

                boolean isWide = false;

                boolean validWheelType = false;
                while(!validWheelType) {
                    if (wheelType.equals("y")||wheelType.equals("n")){
                        validWheelType = true;
                        isWide = wheelType.equals("y");
                    }else {
                        InventoryUi.invalidInputPrompt("Wheel Type");
                        wheelType = getUserInputString().toLowerCase();
                    }
                }
                count = validateCount(currentInventory.getWheelsCount(isWide),count,"Count");
                currentInventory.removeWheels(count,isWide);
                break;
            case 6:
                count = validateCount(currentInventory.getRemoteControllerCount(),count,"Count");
                currentInventory.removeRemoteControllers(count);
                break;
            case 7:
                count = validateCount(currentInventory.getFrameCount(),count,"Count");
                currentInventory.removeFrame(count);
                break;
            case 8:
                count = validateCount(currentInventory.getBatteryCount(),count,"Count");
                currentInventory.removeBatteries(count);
                break;
        }
        InventoryUi.successfulMessagePrompt("Removal of selected items");

    }

    private static void buildCar(){
        InventoryUi.carTypesPrompt();
        InventoryUi.countPrompt("Build");

        int choice = getUserInputInt();
        validateInput(6,choice,"Choice");

        String bodyShellType;
        bodyShellType = chooseExtraShell();
        boolean isWide=false;

        boolean isStreet=false;
        if  (choice < 4){
            isStreet = true;
        }
        if (!isStreet){
            isWide = chooseWheels();
        }
        if(packageBox(bodyShellType,isWide)){
            InventoryUi.successfulMessagePrompt("Built a Car");
        }else   {
            InventoryUi.taskCouldNotBeCompleted("Building a Car");
        }

    }

    private static boolean packageBox(String bodyShellType, boolean isWide) {

        ArrayList<Boolean> allTrue = new ArrayList<>();

        //Removing Body Shell
        allTrue.add(validateCount(currentInventory.getBodyShellsCount(),"Body Shell"));
        currentInventory.removeBodyShell(1,bodyShellType);

        //Removing Wheel
        allTrue.add(validateCount(currentInventory.getWheelsCount(isWide),"Wheels - "+(isWide?" Wide":"Normal")));
        currentInventory.removeWheels(1,isWide);

        //Removing Battery
        allTrue.add(validateCount(currentInventory.getBatteryCount(),"Count"));
        currentInventory.removeBatteries(1);

        //Removing Charger
        allTrue.add(validateCount(currentInventory.getChargersCount(),"Count"));
        currentInventory.removeChargers(1);

        //Removing Frame
        allTrue.add(validateCount(currentInventory.getFrameCount(),"Count"));
        currentInventory.removeFrame(1);

        //Removing Motor
        allTrue.add(validateCount(currentInventory.getMotorsCount(),"Count"));
        currentInventory.removeMotors(1);

        //Removing Remote Controller
        allTrue.add(validateCount(currentInventory.getRemoteControllerCount(),"Count"));
        currentInventory.removeRemoteControllers(1);

        //Removing Shocks
        allTrue.add(validateCount(currentInventory.getShocksCount(),"Count"));
        currentInventory.removeShocks(1);

        if (allTrue.contains(false)){
            return false;
        }
        InventoryUi.successfulMessagePrompt("Car Creation");
        return true;
    }

    private static boolean chooseWheels(){
        InventoryUi.wheelTypePrompt();
        String wheelType = getUserInputString();
        boolean isWide=false;

        boolean validWheelType = false;
        while(!validWheelType) {
            if (wheelType.equals("y")||wheelType.equals("n")){
                validWheelType = true;
                isWide = wheelType.equals("y");
            }else {
                InventoryUi.invalidInputPrompt("Wheel Type");
                wheelType = getUserInputString().toLowerCase();
            }
        }
        return isWide;

    }

    private static String chooseExtraShell(){
        InventoryUi.extraShellPrompt();
        int choice = getUserInputInt();
        validateInput(2,choice,"Choice");

        if (choice == 1){
            return "military";
        }
        return "truck";
    }

    private static int validateInput(int upperLimit, int input, String whatIsWrong){
        boolean validInput = false;
        while (!validInput) {
            if (input < 1 || input > upperLimit) {
                InventoryUi.invalidInputPrompt(whatIsWrong);
                input = getUserInputInt();
            } else validInput = true;
        }
        return input;
    }

    private static int validateCount(int upperLimit, int input, String items){
        boolean validInput = false;
        while (!validInput) {
            if (input < 0 || input > upperLimit) {
                InventoryUi.notEnoughCountPrompt(items,upperLimit);
                input = getUserInputInt();
            } else validInput = true;
        }
        return input;
    }
    
    private static boolean validateCount(int upperLimit,String items){
        if (upperLimit<1) {
            InventoryUi.notEnoughCountPrompt(items,upperLimit);
            return false;
        }
        return true;
    }
}

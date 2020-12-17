package com.devnom.view;


import com.devnom.model.ModelNumber;
import com.devnom.model.Shell;

import java.util.ArrayList;
import java.util.Arrays;

public class InventoryUi {
    public static ArrayList<String> shellTypes = new ArrayList<>
            (Arrays.asList("Sport","SUV","Classic","ATV","Dune Buggy","Crawlers","Military","Trucks"));

    //this is a class with all static method because
    // it doesn't hold any instance values, simply a grouping of methods
    public static void openingMenu() {
        System.out.println(
                "*************************************** \n" +
                        "       Welcome To The Inventory App\n" +
                        "*************************************** \n" +
                        "\t1. Add to Inventory\n" +
                        "\t2. Check Inventory\n" +
                        "\t3. Remove Items\n" +
                        "\t4. Build a Car\n"+
                        "\t\tQ to exit...\n"
        );
    }

    public static void availableItemsPrompt(String whatToDo) {
        //the string whatToDo asks if the prompt is for adding or checking the inventory
        //this is to save redundant code
        System.out.println(
                "************************************************************ \n" +
                "                  Select a type to " + whatToDo +"\n"+
                "************************************************************ \n" +
                        "\t1. Shell\n" +
                        "\t2. Charger\n" +
                        "\t3. Motor\n" +
                        "\t4. Shocks\n" +
                        "\t5. Wheels\n" +
                        "\t6. Remote Controller\n" +
                        "\t7. Frame\n" +
                        "\t8. Battery\n"
        );
    }

    public static void countPrompt(String whatToDo){
        System.out.println("Enter the number you want to "+ whatToDo+ " :");
    }

    public static void shellTypePrompt(){
        System.out.println("Enter the type of the Shell.\n"
                +"Available Shells :");
        for (int i=0;i<shellTypes.size();i++){
            System.out.println("\t"+(i+1)+". "+ shellTypes.get(i));
        }
    }

    public static void wheelTypePrompt(){
        System.out.println("Do you want the wheels to be wide? (Y/N)");
    }

    public static void invalidInputPrompt(String whatIsWrong){
        //the whatIsWrong asks for which input is incorrect so specified message can be sent
        System.err.println("Invalid "+whatIsWrong+ ", Please enter again!");
    }

    public static void getCountPrompt(String item, int count){
        System.out.println("The available number of "+ item + " is : " + count);
    }

    public static void subItemCountPrompt(String item, int count){
        System.out.println("\t"+ item + " : "+count);
    }

    public static void successfulMessagePrompt(String whatWasDone){
        System.out.println(whatWasDone + " successfully done!!!");
    }

    public static void notEnoughCountPrompt(String item, int availableCount){
        System.err.println("Not Enough " + item +"\nAvailable "+item +" : "+ availableCount);
    }

    public static void successfulAdditionPrompt(int count, String item){
        System.out.println("Successfully added " + count + " "+ item);
    }

    public static void carTypesPrompt(){
        System.out.print("1. ");
        modelNumberPrompt(ModelNumber.SPORTS_MODEL);
        System.out.print("2. ");
        modelNumberPrompt(ModelNumber.SUV_MODEL);
        System.out.print("3. ");
        modelNumberPrompt(ModelNumber.CLASSIC_MODEL);
        System.out.print("4. ");
        modelNumberPrompt(ModelNumber.ATV_MODEL);
        System.out.print("5. ");
        modelNumberPrompt(ModelNumber.DUNE_BUGGY_MODEL);
        System.out.print("6. ");
        modelNumberPrompt(ModelNumber.CRAWLER_MODEL);
    }

    public static void modelNumberPrompt(ModelNumber modelNumber){
        System.out.println(modelNumber+" : "+modelNumber.getUPCPrefix() +" "+
                modelNumber.getModelNumber() +" "+ modelNumber.getStartingCount());
    }

    public static void extraShellPrompt(){
        System.out.println("Do you want to change the Shell type?\n" +
                "The following options are available :\n" +
                "1. Military\t2. Truck");
    }

    public static void taskCouldNotBeCompleted(String whatWasInterrupted){
        System.err.println("Couldn't complete "+whatWasInterrupted);
    }
    //Even though the methods are just one line,
    //they are separated for the proper implementation of MVC principals

}

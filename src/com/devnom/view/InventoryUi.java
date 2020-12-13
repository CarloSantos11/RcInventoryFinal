package com.devnom.view;


import com.devnom.model.Shell;

public class InventoryUi {

    //this is a class with all static method because
    // it doesn't hold any instance values, simply a grouping of methods
    public static void openingMenu() {
        System.out.println(
                "*************************************** \n" +
                        "       Welcome To The Inventory App\n" +
                        "*************************************** \n" +
                        "\t1. Add to Inventory\n" +
                        "\t2. Check Inventory\n" +
                        "\t3. Package\n" +
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

    public static void countPrompt(){
        System.out.println("Enter the number you want to add :");
    }

    public static void shellTypePrompt(){
        System.out.println("Enter the type of the Shell.\n"
                +"We have the following types :");
        System.out.println(Shell.shellTypes1.toString());
    }

    public static void wrongShellTypePrompt(){
        System.err.println("The entered shell type doesn't exist!");
        shellTypePrompt();
    }

    public static void wheelTypePrompt(){
        System.out.println("Is the wheel wide?");
    }

    public static void invalidInputPrompt(String whatIsWrong){
        //the whatIsWrong asks for which input is incorrect so specified message can be sent
        System.err.println("Invalid "+whatIsWrong+ ", Please enter again!");
    }

    public static void getCountPrompt(String item, int count){
        System.out.println("The available number of "+ item + " is : " + count);
    }

    public static void successfulMessagePrompt(){
        System.out.println("Task Successfully!");
    }
    //Even though the methods are just one line,
    //they are separated for the proper implementation of MVC principals
}

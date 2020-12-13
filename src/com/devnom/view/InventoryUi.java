package com.devnom.view;


import com.devnom.model.Shell;

public class InventoryUi {




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

    public static void optionAddToInventory() {
        System.out.println(
                "************************************************************ \n" +
                "       What Type Inventory Item Will We Be Adding In? \n" +
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
}

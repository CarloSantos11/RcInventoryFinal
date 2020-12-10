package com.devnom.view;

import java.util.Scanner;

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
                "\t1. Frame\n" +
                    "\t\t1A: Off Road Frame\n" +
                    "\t\t1B: Street Car Frame\n" +
                "\t2. Motor\n" +
                "\t3. Shell\n" +
                    "\t\t1A: Off Road Frame\n" +
                    "\t\t1B: Street Car Frame\n" +
                "\t4. Shocks\n" +
                "\t4. Wheels\n"
        );
    }
}

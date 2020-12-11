package com.devnom.view;

import java.util.Scanner;

public class InventoryUi {



    public static void promptOpeningMenu() {
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

    public static void promptAddToInventory() {
        System.out.println(
                "************************************************************ \n" +
                "       What Type Inventory Item Will We Be Adding In? \n" +
                "************************************************************ \n" +
                "\t1. Frame\n" +
                    "\t\t1A: Off Road Frame\n" +
                    "\t\t1B: Street Car Frame\n" +

                "\t2. Motor\n" +

                "\t3. Shell\n" +
                    "\t\t3A: Classic Shell\n" +
                    "\t\t3B: Sport Shell\n" +
                    "\t\t3C: SUV Shell\n" +

                "\t4. Shocks\n" +

                "\t4. Wheels\n" +
                    "\t\t3A: Standard Wheel\n" +
                    "\t\t3B: Wide Wheel\n"

        );
    }

    public static void promptItemQuantity(String nameOfItem) {
        System.out.println(
                "************************************************************ \n" +
                "       How Many of " + nameOfItem + " Will We Be Adding In? \n" +
                "************************************************************ \n"
        );
    }
}

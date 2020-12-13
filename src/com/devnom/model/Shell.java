package com.devnom.model;

import java.util.ArrayList;
import java.util.Arrays;

public class Shell {
    String type;
    double price;

    public static ArrayList<String> shellTypes = new ArrayList<>
            (Arrays.asList("sport","suv","classic","atv","dune buggy","crawlers","military","trucks"));
    public static ArrayList<String> shellTypes1 = new ArrayList<>
            (Arrays.asList("Sport","SUV","Classic","ATV","Dune Buggy","Crawlers","Military","Trucks"));

    public Shell(String type, double price) {
        this.type = type;
        this.price = price;
    }

    // I have more than a binary option here
    // Possibly use an enum?
    // Same design decision as the frame
}

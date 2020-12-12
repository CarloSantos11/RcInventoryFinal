package com.devnom.model;

public class Shell {
    String type;
    double price;

    public Shell(String type, double price) {
        this.type = type;
        this.price = price;
    }

    // I have more than a binary option here
    // Possibly use an enum?
    // Same design decision as the frame
}

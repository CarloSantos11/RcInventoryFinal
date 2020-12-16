package com.devnom.model;

public class Wheel extends InventoryItem{
    boolean isWide;
    double price;

    public Wheel(boolean isWide, double price) {
        this.isWide = isWide;
        this.price = price;
    }
}

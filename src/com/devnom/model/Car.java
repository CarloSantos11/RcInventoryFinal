package com.devnom.model;

import java.util.ArrayList;

public class Car {
    private final boolean isOffRoad;
    private final Wheel wheels;
    private final Frame frame;
    private final Shell shell;
    private final Motor motor;
    private final Shocks shocks;

    public Car(boolean isOffRoad, Wheel wheels, Frame frame, Shell shell, Motor motor, Shocks shocks) {
        this.isOffRoad = isOffRoad;
        this.wheels = wheels;
        this.frame = frame;
        this.shell = shell;
        this.motor = motor;
        this.shocks = shocks;
    }
}

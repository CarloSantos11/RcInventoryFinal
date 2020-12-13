package com.devnom.model;

import java.util.ArrayList;

public class Inventory {
    ArrayList<Battery> batteries = new ArrayList<>();
    ArrayList<Motor> motors = new ArrayList<>();
    ArrayList<Shell> bodyShells = new ArrayList<>();
    ArrayList<Shocks> shocks = new ArrayList<>();
    ArrayList<Wheel> wheels = new ArrayList<>();
    ArrayList<RemoteController> remoteControllers = new ArrayList<>();
    ArrayList<Charger> chargers = new ArrayList<>();
    ArrayList<Frame> frames = new ArrayList<>();


    public boolean addBatteries(int count){
        if (count>0) {
            for (int i = 0; i < count; i++) {
                Battery battery = new Battery();
                batteries.add(battery);
            }
            return true;
        }
        return false;
    }

    public void addMotors(int count){
        for (int i = 0; i < count; i++) {
            Motor motor = new Motor();
            motors.add(motor);
        }
    }

    public void addFrame(int count){
        for (int i = 0; i < count; i++) {
            Frame frame = new Frame();
            frames.add(frame);
        }
    }

    public void addRemoteControllers(int count){
        for (int i = 0; i < count; i++) {
            RemoteController remoteController = new RemoteController();
            remoteControllers.add(remoteController);
        }
    }

    public void addBodyShell(int count,String bodyShellType,double price){
        for (int i = 0; i < count; i++) {
            Shell bodyShell = new Shell(bodyShellType,price);
            bodyShells.add(bodyShell);
        }
    }

    public void addBodyShell(int count,String bodyShellType){
        addBodyShell(count,bodyShellType,0);
    }

    public void addShocks(int count){
        for (int i = 0; i < count; i++) {
            Shocks shocks = new Shocks();
            this.shocks.add(shocks);
        }
    }

    public void addWheels(int count, boolean isWide, double price){
        for (int i = 0; i < count; i++) {
            Wheel wheel = new Wheel(isWide,price);
            wheels.add(wheel);
        }
    }

    public void addWheels(int count, boolean isWide){
        addWheels(count,isWide,0);
    }

    public void addChargers(int count){
        for (int i = 0; i < count; i++) {
            Charger charger = new Charger();
            chargers.add(charger);
        }
    }


    public int getBatteryCount() {
        return batteries.size();
    }

    public int getMotorsCount() {
        return motors.size();
    }

    public int getBodyShellsCount() {
        return bodyShells.size();
    }

    public int getShocksCount() {
        return shocks.size();
    }

    public int getWheelsCount() {
        return wheels.size();
    }

    public int getRemoteControllerCount() {
        return remoteControllers.size();
    }

    public int getChargersCount() {
        return chargers.size();
    }

    public int getFrameCount(){
        return frames.size();
    }
}

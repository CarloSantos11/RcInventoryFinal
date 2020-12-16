package com.devnom.model;

import java.util.*;

public class Inventory<Item extends InventoryItem> {

    ArrayList<Battery> batteries = new ArrayList<>();
    ArrayList<Motor> motors = new ArrayList<>();
    ArrayList<Shell> bodyShells = new ArrayList<>();
    ArrayList<Shocks> shocks = new ArrayList<>();
    ArrayList<Wheel> wheels = new ArrayList<>();
    ArrayList<RemoteController> remoteControllers = new ArrayList<>();
    ArrayList<Charger> chargers = new ArrayList<>();
    ArrayList<Frame> frames = new ArrayList<>();

    ArrayList<Wheel> wideWheels = new ArrayList<>();
    ArrayList<Wheel> normalWheels = new ArrayList<>();

    public static ArrayList<String> shellTypes = new ArrayList<>
            (Arrays.asList("sport","suv","classic","atv","dune buggy","crawlers","military","trucks"));

    public void addBatteries(int count){
        for (int i = 0; i < count; i++) {
            Battery battery = new Battery();
            batteries.add(battery);
        }
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
        bodyShellType =bodyShellType.toLowerCase();
        if (shellTypes.contains(bodyShellType)){
            for (int i=0;i<count;i++){
                Shell bodyShell = new Shell(bodyShellType,price);
                bodyShells.add(bodyShell);
                switch (bodyShellType){
                    case "sport":
                        BodyShellTypes.Sport.incrementCount(count);
                    case "suv":
                        BodyShellTypes.SUV.incrementCount(count);
                    case "atv":
                        BodyShellTypes.ATV.incrementCount(count);
                    case "military":
                        BodyShellTypes.Military.incrementCount(count);
                    case "trucks":
                        BodyShellTypes.Trucks.incrementCount(count);
                    case "classic":
                        BodyShellTypes.Classic.incrementCount(count);
                    case "dune buggy":
                        BodyShellTypes.DuneBuggy.incrementCount(count);
                    case "crawlers":
                        BodyShellTypes.Crawlers.incrementCount(count);
                }
            }
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
            if (isWide){
                wideWheels.add(wheel);
            }else {
                normalWheels.add(wheel);
            }
        }
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
        return BodyShellTypes.totalCount();
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

    public int getWideWheelsCount(){
        return wideWheels.size();
    }

    public int getNormalWheelsCount(){
        return normalWheels.size();
    }

    public boolean removeBatteries(int count){
        if (getBatteryCount()>=count){
            for (int i=0;i<count;i++){
                batteries.remove(i);
            }
            return true;
        }
        return false;
    }

    public boolean removeFrame(int count){
        if (getFrameCount()>=count){
            for (int i=0;i<count;i++){
                frames.remove(i);
            }
            return true;
        }
        return false;
    }

    public boolean removeMotors(int count){
        if (getMotorsCount()>=count){
            for (int i=0;i<count;i++){
                motors.remove(i);
            }
            return true;
        }
        return false;
    }

    public boolean removeShocks(int count){
        if (getShocksCount()>=count){
            for (int i=0;i<count;i++){
                shocks.remove(i);
            }
            return true;
        }
        return false;
    }

    public boolean removeRemoteControllers(int count){
        if (getRemoteControllerCount()>=count){
            for (int i=0;i<count;i++){
                remoteControllers.remove(i);
            }
            return true;
        }
        return false;
    }

    public boolean removeChargers(int count){
        if (getChargersCount()>=count){
            for (int i=0;i<count;i++){
                chargers.remove(i);
            }
            return true;
        }
        return false;
    }

    public boolean removeBodyShell(int count){
        if (getBodyShellsCount()>=count){
            for (int i=0;i<count;i++){
                bodyShells.remove(i);
            }
            return true;
        }
        return false;
    }

    public boolean removeBodyShell(int count, String bodyShellType){
        switch (bodyShellType){
            case "sport":
                return BodyShellTypes.Sport.decrementCount(count);
            case "suv":
                return BodyShellTypes.SUV.decrementCount(count);
            case "atv":
                return BodyShellTypes.ATV.decrementCount(count);
            case "military":
                return BodyShellTypes.Military.decrementCount(count);
            case "trucks":
                return BodyShellTypes.Trucks.decrementCount(count);
            case "classic":
                return BodyShellTypes.Classic.decrementCount(count);
            case "dune buggy":
                return BodyShellTypes.DuneBuggy.decrementCount(count);
            case "crawlers":
                return BodyShellTypes.Crawlers.decrementCount(count);
        }
        return false;
    }

    public boolean removeWheels(int count, boolean isWide){
        if (getWheelsCount()>=count){
            if (isWide && getWideWheelsCount()>=count){
                for (int i=0;i<count;i++){
                    Wheel wheel = wideWheels.get(i);
                    wheels.remove(wheel);
                    wideWheels.remove(i);
                }
                return true;
            }else if(getNormalWheelsCount()>=count){
                for (int i=0;i<count;i++){
                    Wheel wheel = wideWheels.get(i);
                    wheels.remove(wheel);
                    normalWheels.remove(i);
                }
                return true;
            }
            return false;

        }
        return false;
    }

}

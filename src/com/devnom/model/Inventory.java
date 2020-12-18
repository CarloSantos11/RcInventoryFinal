package com.devnom.model;

import java.util.*;

public class Inventory {

    // REFACTOR: I definitely think there is
    // Rework that can be done here
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
            for (int i=0;i<count;i++) {
                Shell bodyShell = new Shell(bodyShellType, price);
                bodyShells.add(bodyShell);
            }
            switch (bodyShellType){
                case "sport":
                    BodyShellTypes.Sport.incrementCount(count);
                    break;
                case "suv":
                    BodyShellTypes.SUV.incrementCount(count);
                    break;
                case "atv":
                    BodyShellTypes.ATV.incrementCount(count);
                    break;
                case "military":
                    BodyShellTypes.Military.incrementCount(count);
                    break;
                case "trucks":
                    BodyShellTypes.Trucks.incrementCount(count);
                    break;
                case "classic":
                    BodyShellTypes.Classic.incrementCount(count);
                    break;
                case "dune buggy":
                    BodyShellTypes.DuneBuggy.incrementCount(count);
                    break;
                case "crawlers":
                    BodyShellTypes.Crawlers.incrementCount(count);
                    break;
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
    public int getBodyShellsCount(String bodyShellType){
        switch (bodyShellType){
            case "sport":
                return BodyShellTypes.Sport.getCount();
            case "suv":
                return BodyShellTypes.SUV.getCount();
            case "atv":
                return BodyShellTypes.ATV.getCount();
            case "military":
                return BodyShellTypes.Military.getCount();
            case "trucks":
                return BodyShellTypes.Trucks.getCount();
            case "classic":
                return BodyShellTypes.Classic.getCount();
            case "dune buggy":
                return BodyShellTypes.DuneBuggy.getCount();
            case "crawlers":
                return BodyShellTypes.Crawlers.getCount();
        }
        return -1;
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


    public int getWheelsCount(boolean isWide){
        if (isWide){
            return wideWheels.size();
        }
        else return normalWheels.size();
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

    private boolean removeBodyShell(int count){
        if (getBodyShellsCount()>=count){
            for (int i=0;i<count;i++){
                bodyShells.remove(i);
            }
            return true;
        }
        return false;
    }

    public boolean removeBodyShell(int count, String bodyShellType){
        removeBodyShell(count);
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
        Wheel wheel;
        if (getWheelsCount()>=count){
            if (getWheelsCount(isWide)>=count){
                for (int i=0;i<count;i++){
                    if (isWide){
                        wheel = wideWheels.get(i);
                        wideWheels.remove(wheel);
                    }else {
                        wheel = normalWheels.get(i);
                        normalWheels.remove(wheel);
                    }
                    wheels.remove(wheel);
                }
                return true;
            }
            return false;
        }
        return false;
    }

}

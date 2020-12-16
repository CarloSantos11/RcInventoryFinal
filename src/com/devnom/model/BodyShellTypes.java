package com.devnom.model;

public enum BodyShellTypes {
    Sport(true,false,0),
    SUV(true,false,0),
    Classic(true,false,0),
    ATV(false,false,0),
    DuneBuggy(false,false,0),
    Crawlers(false,false,0),
    Military(true,0),
    Trucks(true,0);

    private boolean isOffRoad;
    private boolean isPurchased;
    private int count;

    BodyShellTypes(boolean isOffRoad, boolean isPurchased,int count) {
        this.isOffRoad = isOffRoad;
        this.isPurchased = isPurchased;
    }

    BodyShellTypes(boolean isPurchased, int count) {
        this.isPurchased = isPurchased;
    }

    public boolean isOffRoad() {
        return isOffRoad;
    }

    public boolean isPurchased() {
        return isPurchased;
    }

    public int getCount() {
        return count;
    }

    public void incrementCount(int count) {
        this.count+=count;
    }

    public boolean decrementCount(int count){
        if (this.count>=count){
            this.count-=count;
            return true;
        }
        return false;
    }

    public static int totalCount(){
        return ATV.getCount()+Crawlers.getCount()+DuneBuggy.getCount()+Military.getCount()+Trucks.getCount()+SUV.getCount()+Classic.getCount()+Sport.getCount();
    }
}


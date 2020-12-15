package com.devnom.model;

import java.util.ArrayList;
import java.util.Arrays;

public enum BodyShellTypes {
    Sport(true,false),
    SUV(true,false),
    Classic(true,false),
    ATV(false,false),
    DuneBuggy(false,false),
    Crawlers(false,false),
    Military(true),
    Trucks(true);

    private boolean isOffRoad;
    private boolean isPurchased;

    BodyShellTypes(boolean isOffRoad, boolean isPurchased) {
        this.isOffRoad = isOffRoad;
        this.isPurchased = isPurchased;
    }

    BodyShellTypes(boolean isPurchased) {
        this.isPurchased = isPurchased;
    }
}


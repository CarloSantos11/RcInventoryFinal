package com.devnom.model;

public enum ModelNumber {

    SPORTS_MODEL("SPT2019","357901",9753),
    SUV_MODEL("SUV3019","942852",8647),
    CLASSIC_MODEL("CLS4019","315790",7326),
    ATV_MODEL("ORAT2400","113342",8488),
    DUNE_BUGGY_MODEL("ORDB3400","885532",7446),
    CRAWLER_MODEL("ORCR4600","756643",3398);

    String modelNumber;
    String UPCPrefix;
    int StartingCount;

    ModelNumber(String modelNumber, String UPCPrefix, int startingCount) {
        this.modelNumber = modelNumber;
        this.UPCPrefix = UPCPrefix;
        StartingCount = startingCount;
    }
}

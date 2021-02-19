package com.epam.task.four.enteties.enums;

public enum MedicineEnum {

    VITAMINS("vitamins"),
    ANTIBIOTICS("antibiotics"),
    PAIN_RELIVERS ("pain-relivers"),
    LIME ("lime"),
    CHERRY ("cherry"),
    APPLE ("apple"),
    ORANGE ("orange");

    private final String name;

    private MedicineEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    }

package com.epam.task.four.enteties.enums;

public enum FlavoringType {

    LIME("lime"), CHERRY("cherry"), APPLE("apple"), ORANGE("orange");

    private String name;

    FlavoringType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

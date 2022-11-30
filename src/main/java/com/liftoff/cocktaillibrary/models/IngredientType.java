package com.liftoff.cocktaillibrary.models;

public enum IngredientType {
    SPIRIT("Spirit"),
    LIQUEUR ("Liqueur"),
    VERMOUTH_OR_WINE ("Vermouth/Wine"),
    SYRUP ("Syrup"),
    JUICE ("Juice"),
    MIXER ("Mixer"),
    EGG ("Egg"),
    BITTERS ("Bitters");

    private final String displayName;

    IngredientType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}


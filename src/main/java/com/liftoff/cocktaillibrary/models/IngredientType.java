package com.liftoff.cocktaillibrary.models;

import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

public enum IngredientType {
//    SELECT_INGREDIENT_TYPE("Select Ingredient Type"),
    SPIRIT("Spirit"),
    LIQUEUR ("Liqueur"),
    VERMOUTH_OR_WINE ("Vermouth/Wine"),
    SYRUP ("Syrup"),
    JUICE ("Juice"),
    MIXER ("Mixer"),
    EGG ("Egg"),
    BITTERS ("Bitters");

    private final String displayName;

    @ManyToMany
    private final List<Recipe> recipes = new ArrayList<>();

    IngredientType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }
}

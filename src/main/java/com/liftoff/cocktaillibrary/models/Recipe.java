package com.liftoff.cocktaillibrary.models;

import java.util.HashMap;
import java.util.List;

public class Recipe extends AbstractEntity {

    private HashMap<Ingredient, IngredientAmount> recipeIngredients;
    private List<Tag> tags;

    public Recipe (){};

    public Recipe (HashMap<Ingredient, IngredientAmount> recipeIngredients, List<Tag> tags){
        this.recipeIngredients = recipeIngredients;
        this.tags = tags;
    }


    public HashMap<Ingredient, IngredientAmount> getRecipeIngredients() {
        return recipeIngredients;
    }

    public void setRecipeIngredients(HashMap<Ingredient, IngredientAmount> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}
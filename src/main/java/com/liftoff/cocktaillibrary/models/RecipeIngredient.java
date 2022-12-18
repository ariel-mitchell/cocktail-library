package com.liftoff.cocktaillibrary.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
public class RecipeIngredient extends AbstractEntity{

    @ManyToOne
    private Ingredient ingredient;
    private IngredientAmount ingredientAmount;

    @ManyToMany(mappedBy = "recipeIngredients")
    private List<Recipe> recipes = new ArrayList<>();

    public RecipeIngredient(){};

    public RecipeIngredient(Ingredient ingredient, IngredientAmount ingredientAmount) {
        this.ingredient = ingredient;
        this.ingredientAmount = ingredientAmount;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public IngredientAmount getIngredientAmount() {
        return ingredientAmount;
    }

    public void setIngredientAmount(IngredientAmount ingredientAmount) {
        this.ingredientAmount = ingredientAmount;
    }
}

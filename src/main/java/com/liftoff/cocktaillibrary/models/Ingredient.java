package com.liftoff.cocktaillibrary.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Ingredient extends AbstractEntity {

    private  IngredientType ingredientType;

    @OneToMany(mappedBy = "ingredient")
    private List<RecipeIngredient> recipeIngredients = new ArrayList<>();


    public Ingredient(){};
    public Ingredient(IngredientType ingredientType){
        this.ingredientType=ingredientType;
    }

    public IngredientType getIngredientType() {
        return ingredientType;
    }

    public void setIngredientType(IngredientType ingredientType) {
        this.ingredientType = ingredientType;
    }


//    public String getIngredientAmount() {
//        return ingredientAmount;
//    }
//
//    public void setIngredientAmount(String ingredientAmount) {
//        this.ingredientAmount = ingredientAmount;
//    }


}
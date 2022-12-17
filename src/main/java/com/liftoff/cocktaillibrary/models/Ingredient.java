package com.liftoff.cocktaillibrary.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Ingredient extends AbstractEntity {

    private  IngredientType ingredientType;

    private IngredientAmount ingredientAmount;

    @ManyToMany(mappedBy = "ingredients")

    private List<Recipe> recipes = new ArrayList<>();
    public Ingredient(){};
    public Ingredient(IngredientType ingredientType){
        this.ingredientType=ingredientType;
    }

    public Ingredient (IngredientType ingredientType, IngredientAmount ingredientAmount){
        this.ingredientType = ingredientType;
        this.ingredientAmount= ingredientAmount;
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
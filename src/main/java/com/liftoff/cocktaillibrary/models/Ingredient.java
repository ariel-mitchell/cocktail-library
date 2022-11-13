package com.liftoff.cocktaillibrary.models;

public class Ingredient extends AbstractEntity {

    private  String ingredientType;
    private  String ingredientName;
    private  Double ingredientAmount;

    public Ingredient(){};

    public Ingredient (String ingredientType, String ingredientName, Double ingredientAmount){
        this.ingredientType = ingredientType;
        this.ingredientName = ingredientName;
        this.ingredientAmount= ingredientAmount;
    }

    public String getIngredientType() {
        return ingredientType;
    }

    public void setIngredientType(String ingredientType) {
        this.ingredientType = ingredientType;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public Double getIngredientAmount() {
        return ingredientAmount;
    }

    public void setIngredientAmount(Double ingredientAmount) {
        this.ingredientAmount = ingredientAmount;
    }


}

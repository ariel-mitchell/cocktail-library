package com.liftoff.cocktaillibrary.models;

import java.util.ArrayList;

public class RecipeData {


    //Do we want the ability to search within specific fields or is the List going to take care of that part of filtering?

    public static ArrayList<Recipe> findByKeyword(String searchTerm, Iterable<Recipe> allRecipes){

        ArrayList<Recipe> results = new ArrayList<>();

        for (Recipe recipe : allRecipes){
            if (recipe.getName().toLowerCase().contains(searchTerm.toLowerCase())){
                results.add(recipe);
            }else if (recipe.getRecipeIngredients().keySet().getClass().getName().toLowerCase().contains(searchTerm.toLowerCase())) {
                results.add(recipe);
            }else if (recipe.getTags().toString().toLowerCase().contains(searchTerm.toLowerCase())){
                results.add(recipe);

            }
        }
        return results;
    }

    public static ArrayList<Ingredient> findByType(String ingredientType, Iterable<Ingredient> allIngredients){
        ArrayList<Ingredient> results = new ArrayList<>();

        for (Ingredient ingredient: allIngredients){
            if (ingredient.getIngredientType().toString().toLowerCase().contains(ingredientType)){
                results.add(ingredient);
            }

        }
        return results;
    }





}
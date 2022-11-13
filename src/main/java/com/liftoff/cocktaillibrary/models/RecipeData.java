package com.liftoff.cocktaillibrary.models;

import java.util.ArrayList;

public class RecipeData {


    //Do we want the ability to search within specific fields or is the List going to take care of that part of filtering?

    public static ArrayList<Recipe> searchWithKeyword(String searchTerm, Iterable<Recipe> allRecipes){

        ArrayList<Recipe> results = new ArrayList<>();

        for (Recipe recipe : allRecipes){
            if (recipe.getName().toLowerCase().contains(searchTerm.toLowerCase())){
                results.add(recipe);
            }else if (recipe.getIngredients().toString().toLowerCase().contains(searchTerm.toLowerCase())) {
                results.add(recipe);
            }else if (recipe.getTags().toString().toLowerCase().contains(searchTerm.toLowerCase())){
                results.add(recipe);

            }
        }
        return results;
    }

}

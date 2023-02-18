package com.liftoff.cocktaillibrary.models;


import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
public class Recipe extends AbstractEntity {

    @ElementCollection
    @ManyToMany
    private List<RecipeIngredient> recipeIngredients;

    @ManyToMany
    private List<Tag> tags;

    public Recipe (){};

    public Recipe (List<RecipeIngredient> recipeIngredients){
        this.recipeIngredients=recipeIngredients;
    }

    public Recipe(List<RecipeIngredient> recipeIngredients, List<Tag> tags) {
        this.recipeIngredients = recipeIngredients;
        this.tags = tags;
    }

    public List<RecipeIngredient> getRecipeIngredients() {
        return recipeIngredients;
    }

    public void setRecipeIngredients(List<RecipeIngredient> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}
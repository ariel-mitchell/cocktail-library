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


@ElementCollection(targetClass = IngredientAmount.class)
@MapKeyClass(Ingredient.class)
    private Map<Ingredient, IngredientAmount> recipeIngredients;

@ManyToMany
    private List<Tag> tags;


    public Recipe (){};

    public Recipe (Map<Ingredient, IngredientAmount> recipeIngredients, List<Tag> tags){
        this.recipeIngredients = recipeIngredients;
        this.tags = tags;
    }


    public Map<Ingredient, IngredientAmount> getRecipeIngredients() {
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
package com.liftoff.cocktaillibrary.models;

import javax.persistence.Entity;
import java.util.List;

@Entity
public class Recipe extends AbstractEntity {

    private List<Ingredient> ingredients;
    private List<Tag> tags;

    public Recipe (){};

    public Recipe (List<Ingredient> ingredients, List<Tag> tags){
        this.ingredients = ingredients;
        this.tags = tags;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}
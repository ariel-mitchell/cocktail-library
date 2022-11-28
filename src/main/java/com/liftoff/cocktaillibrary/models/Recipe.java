package com.liftoff.cocktaillibrary.models;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Recipe extends AbstractEntity {
    @OneToMany
    private List<Ingredient> ingredients = new ArrayList<>();

    @OneToMany
    private List<Tag> tags = new ArrayList<>();

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
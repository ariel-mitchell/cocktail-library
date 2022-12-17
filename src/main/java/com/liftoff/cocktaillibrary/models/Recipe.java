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
private List<Ingredient> ingredients;

    @ManyToMany
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
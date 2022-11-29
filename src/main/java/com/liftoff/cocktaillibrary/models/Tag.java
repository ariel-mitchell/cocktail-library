package com.liftoff.cocktaillibrary.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Tag extends AbstractEntity {
//    private String tag;

//    public Tag (String tag){
//        this.tag = tag;
//    }

    @ManyToMany(mappedBy="tags")
    private final List<Recipe> recipes = new ArrayList<>();

    public Tag(){};

    public List<Recipe> getRecipes() {
        return recipes;
    }
//    public String getTag() {
//        return tag;
//    }
//
//    public void setTag(String tag) {
//        this.tag = tag;
//    }
}

package com.liftoff.cocktaillibrary.models;

public class Tag extends AbstractEntity {
    private String tag;

    public Tag(){};

    public Tag(String tag){
        this.tag = tag;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}

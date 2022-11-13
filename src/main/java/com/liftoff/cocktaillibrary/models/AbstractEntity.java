package com.liftoff.cocktaillibrary.models;

import com.fasterxml.jackson.annotation.JsonTypeId;
import org.springframework.web.bind.annotation.RequestMapping;



public abstract class AbstractEntity {
//    @Id
//    @GeneratedValue
    private int id;


    private String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}


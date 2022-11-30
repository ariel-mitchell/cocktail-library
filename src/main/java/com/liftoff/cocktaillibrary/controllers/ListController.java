package com.liftoff.cocktaillibrary.controllers;

import com.liftoff.cocktaillibrary.models.data.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "list-recipes")
public class ListController {

    @Autowired
    private RecipeRepository recipeRepository;

    @RequestMapping("")
    public String list(Model model){
        model.addAttribute("title", "View Recipes By Category");

        return "list-recipes";
    }

}

package com.liftoff.cocktaillibrary.controllers;

import com.liftoff.cocktaillibrary.models.data.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "search")
public class SearchController {


    @Autowired
    private RecipeRepository recipeRepository;

    @RequestMapping("")
    public String search(Model model){
        model.addAttribute("title", "Search By");

        return "search";

    }


}
package com.liftoff.cocktaillibrary.controllers;

import com.liftoff.cocktaillibrary.models.Recipe;
import com.liftoff.cocktaillibrary.models.RecipeData;
import com.liftoff.cocktaillibrary.models.data.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("search")
public class SearchController {


    @Autowired
    private RecipeRepository recipeRepository;

    @RequestMapping("")
    public String search(Model model){
        model.addAttribute("title", "Search By");

        return "search";

    }

    @PostMapping("results")
    public String displayResults(Model model, @RequestParam String searchTerm){
        Iterable<Recipe> recipes;
        if (searchTerm.equals("") || searchTerm.toLowerCase().equals("all")){
            recipes=recipeRepository.findAll();
        }else{
            recipes= RecipeData.findByKeyword(searchTerm, recipeRepository.findAll());
        }
        model.addAttribute("recipes", recipes);
        return "search";
    }


}
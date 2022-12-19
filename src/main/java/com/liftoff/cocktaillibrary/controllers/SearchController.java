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

import java.util.ArrayList;
import java.util.Optional;

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

    @PostMapping("")
    public String displayResults(Model model, @RequestParam String searchTerm){
        if (searchTerm == "" || searchTerm.toLowerCase().equals("all")) {
            model.addAttribute("title", "All Recipes");
            model.addAttribute("recipes", recipeRepository.findAll());
        } else {
            ArrayList<Recipe> result = RecipeData.findByKeyword(searchTerm, recipeRepository.findAll());
            if (result.isEmpty()) {
                model.addAttribute("title", "No recipes matching search term: " + searchTerm);
            } else {
                model.addAttribute("title", "Recipes Matching '" + searchTerm + "':");
                model.addAttribute("recipes", RecipeData.findByKeyword(searchTerm, recipeRepository.findAll()));
            }
        }
        return "search";
    }


}
package com.liftoff.cocktaillibrary.controllers;

import com.liftoff.cocktaillibrary.models.Recipe;
import com.liftoff.cocktaillibrary.models.RecipeData;
import com.liftoff.cocktaillibrary.models.data.IngredientRepository;
import com.liftoff.cocktaillibrary.models.data.RecipeRepository;
import com.liftoff.cocktaillibrary.models.data.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Controller
@RequestMapping(value = "list")
public class ListController {

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private TagRepository tagRepository;

    static HashMap<String, String> listByChoices = new HashMap<>();

    public ListController(){
        listByChoices.put("all", "All");
        listByChoices.put("ingredients", "Ingredients");
        listByChoices.put("tags", "Tags");
    }

    @RequestMapping("")
    public String list(Model model){
        model.addAttribute("ingredients", RecipeData.findByType("spirit", ingredientRepository.findAll()));
        model.addAttribute("tags", tagRepository.findAll());
        return "list";
    }

    @RequestMapping(value = "recipes")
    public String listRecipes(Model model, @RequestParam String choice){
        Iterable<Recipe> recipes;
        if (choice.toLowerCase().equals("all")){
            recipes = recipeRepository.findAll();
        }else{
            recipes = RecipeData.findByKeyword(choice, recipeRepository.findAll());
        }
        model.addAttribute("recipes", recipes);
        return "list-recipes";
    }


}















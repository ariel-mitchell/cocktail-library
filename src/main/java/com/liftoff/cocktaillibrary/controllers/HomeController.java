package com.liftoff.cocktaillibrary.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liftoff.cocktaillibrary.models.*;
import com.liftoff.cocktaillibrary.models.data.IngredientRepository;
import com.liftoff.cocktaillibrary.models.data.RecipeIngredientRepository;
import com.liftoff.cocktaillibrary.models.data.RecipeRepository;
import com.liftoff.cocktaillibrary.models.data.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import com.google.gson.Gson;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@Controller
public class HomeController {

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private RecipeIngredientRepository recipeIngredientRepository;

    @RequestMapping("")
    public String index(Model model) {
        model.addAttribute("title", "Recipes");
        model.addAttribute("recipes",recipeRepository.findAll());
        return "index";
    }

    @GetMapping("add-account")
    public String displayAddAccountForm(Model model) {
        model.addAttribute("title", "Create An Account");
        return "user/add-account";
    }


    @GetMapping("add")
    public String displayCreateRecipeForm(Model model){
        model.addAttribute("title", "Create Recipe");
        model.addAttribute("tags", tagRepository.findAll());
        List<IngredientType> ingredientTypes = Arrays.asList(IngredientType.values());
        model.addAttribute("ingredientTypes", ingredientTypes);

        model.addAttribute("ingredients", ingredientRepository.findAll());
        List<IngredientAmount> ingredientAmounts = Arrays.asList(IngredientAmount.values());
        model.addAttribute("ingredientAmounts", ingredientAmounts);
        model.addAttribute(new Recipe());

//        @RequestParam(required = false, name="ingredientType") IngredientType ingredientType)
//        List<Ingredient> ingredients = RecipeData.findByType(ingredientType, ingredientRepository.findAll());
//        model.addAttribute("ingredients",ingredients);

        return "add";
    }

    @PostMapping("add")
    public String processAddRecipeForm(@ModelAttribute @Valid Recipe newRecipe,
                                    Errors errors, Model model, @RequestParam List<Integer> ingredientIds, @RequestParam List<IngredientAmount> ingredientAmounts, @RequestParam(defaultValue = "") List<Integer> tagIds) {


        ArrayList<RecipeIngredient> recipeIngredients = new ArrayList<RecipeIngredient>();

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Recipe");
            return "add";

        }else{

            List<Tag> tags = (List<Tag>) tagRepository.findAllById(tagIds);
            List<Ingredient> ingredients = (List<Ingredient>) ingredientRepository.findAllById(ingredientIds);



            for (int i=0; i<ingredients.size(); i++){
                RecipeIngredient recipeIngredient = new RecipeIngredient(ingredients.get(i), ingredientAmounts.get(i));
                recipeIngredientRepository.save(recipeIngredient);
                recipeIngredients.add(recipeIngredient);
            }
            newRecipe.setRecipeIngredients(recipeIngredients);
            newRecipe.setTags(tags);
        }
        recipeRepository.save(newRecipe);
        return "redirect:";
    }



    @PostMapping("add-account")
    public String processAddAccountForm(Model model) {
        return "redirect:";
    }
}



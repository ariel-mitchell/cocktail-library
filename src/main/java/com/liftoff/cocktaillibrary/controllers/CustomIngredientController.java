package com.liftoff.cocktaillibrary.controllers;

import com.liftoff.cocktaillibrary.models.Ingredient;
import com.liftoff.cocktaillibrary.models.IngredientType;
import com.liftoff.cocktaillibrary.models.data.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.ejb.DuplicateKeyException;
import javax.management.Query;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("custom-ingredients")
public class CustomIngredientController {
    @Autowired
    private IngredientRepository ingredientRepository;

    @GetMapping("")
    public String index(Model model){
        model.addAttribute("title", "Ingredient");
        model.addAttribute("ingredients", ingredientRepository.findAll());
        return "/custom-ingredients";
    }

    @GetMapping("add")
    public String displayAddCustomIngredientForm(Model model){
        List<IngredientType> ingredientTypes = Arrays.asList(IngredientType.values());
        model.addAttribute("title", "Add A New Ingredient");
        model.addAttribute("ingredientTypes", ingredientTypes);
        model.addAttribute(new Ingredient());
        return "custom-ingredients/add";
    }

    @PostMapping("add")
    public String processAddCustomIngredientForm(@ModelAttribute @Valid Ingredient newIngredient, Errors errors, Model model){
        List<Ingredient> currentIngredients = (List<Ingredient>) ingredientRepository.findAll();
        List<IngredientType> ingredientTypes = Arrays.asList(IngredientType.values());

        if (errors.hasErrors()) {
            model.addAttribute("ingredientTypes", ingredientTypes);
            model.addAttribute("title", "Add A New Ingredient");
            return "/custom-ingredients/add";
        }

        for (int i=0; i<currentIngredients.size(); i++) {
            if (currentIngredients.get(i).getName().contains(newIngredient.getName())) {
                model.addAttribute("title", "Ingredient Already Exists");
                model.addAttribute("ingredientTypes", ingredientTypes);
                return "custom-ingredients/add";
            }
        }

        ingredientRepository.save(newIngredient);
        return"redirect:../add";
    }

}


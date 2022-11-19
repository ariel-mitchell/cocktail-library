package com.liftoff.cocktaillibrary.controllers;

import com.liftoff.cocktaillibrary.models.Ingredient;
import com.liftoff.cocktaillibrary.models.IngredientType;
import com.liftoff.cocktaillibrary.models.data.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

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
        model.addAttribute("ingredientTypes", ingredientTypes);
        model.addAttribute(new Ingredient());
        return "custom-ingredients/add";
    }

    @PostMapping("add")
    public String processAddCustomIngredientForm(@ModelAttribute @Valid Ingredient newIngredient, Errors errors, Model model){
        if (errors.hasErrors()){
            return "custom-ingredients/add";
        }else{
            ingredientRepository.save(newIngredient);
            return"redirect:../add";
        }
    }
}

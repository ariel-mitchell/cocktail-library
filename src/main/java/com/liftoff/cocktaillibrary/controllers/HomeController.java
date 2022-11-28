package com.liftoff.cocktaillibrary.controllers;

import com.liftoff.cocktaillibrary.models.Ingredient;
import com.liftoff.cocktaillibrary.models.IngredientType;
import com.liftoff.cocktaillibrary.models.RecipeData;
import com.liftoff.cocktaillibrary.models.data.IngredientRepository;
import com.liftoff.cocktaillibrary.models.data.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    @RequestMapping("")
    public String index(Model model) {
        model.addAttribute("title", "Log In");
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

//        @RequestParam(required = false, name="ingredientType") IngredientType ingredientType)
//        List<Ingredient> ingredients = RecipeData.findByType(ingredientType, ingredientRepository.findAll());
//        model.addAttribute("ingredients",ingredients);

        return "add";
    }



    @PostMapping("add-account")
    public String processAddAccountForm(Model model) {
        return "redirect:";
    }
}



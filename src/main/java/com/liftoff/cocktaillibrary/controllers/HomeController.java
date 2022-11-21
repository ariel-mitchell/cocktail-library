package com.liftoff.cocktaillibrary.controllers;

import com.liftoff.cocktaillibrary.models.IngredientType;
import com.liftoff.cocktaillibrary.models.Recipe;
import com.liftoff.cocktaillibrary.models.data.IngredientRepository;
import com.liftoff.cocktaillibrary.models.data.RecipeRepository;
import com.liftoff.cocktaillibrary.models.data.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private RecipeRepository recipeRepository;

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

    @PostMapping("add-account")
    public String processAddAccountForm(Model model) {
        return "redirect:";
    }


    @GetMapping("add")
    public String displayCreateRecipeForm(Model model){
        model.addAttribute("title", "Create Recipe");
        model.addAttribute("ingredients", ingredientRepository.findAll());
        model.addAttribute("tags", tagRepository.findAll());
        List<IngredientType> ingredientTypes = Arrays.asList(IngredientType.values());
        model.addAttribute("ingredientTypes", ingredientTypes);

        return "add";
    }

    @PostMapping("add")
    public String processCreateRecipeForm(@ModelAttribute @Valid Recipe newRecipe,
                                            Errors errors, Model model){
        if(errors.hasErrors()){
            model.addAttribute("title" , "Create Recipe");
            return "add";
        }
        recipeRepository.save(newRecipe);
        return "redirect:";
    }
}



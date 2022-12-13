package com.liftoff.cocktaillibrary.controllers;


import com.liftoff.cocktaillibrary.models.*;
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
import java.util.HashMap;
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
        model.addAttribute("title", "Recipes");
        model.addAttribute("recipes",recipeRepository.findAll());
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
        model.addAttribute("tags", tagRepository.findAll());
        List<IngredientType> ingredientTypes = Arrays.asList(IngredientType.values());
        model.addAttribute("ingredientTypes", ingredientTypes);

        model.addAttribute("ingredients", ingredientRepository.findAll());

        model.addAttribute("ingredients", ingredientRepository.findAll());

        List<IngredientAmount> ingredientAmounts = Arrays.asList(IngredientAmount.values());
        model.addAttribute("ingredientAmounts", ingredientAmounts);
        model.addAttribute(new Recipe());


        return "add";
    }

    @PostMapping("add")
    public String processCreateRecipeForm(@ModelAttribute @Valid Recipe newRecipe,
                                    Errors errors, Model model, @RequestParam List<Integer> ingredientIds,
                                          @RequestParam List<IngredientAmount> ingredientAmounts,
                                          @RequestParam List<Integer> tagIds) {

         HashMap<Ingredient, IngredientAmount> recipeIngredients = new HashMap<>();

        if (errors.hasErrors()) {
            model.addAttribute("title", "Create Recipe");
            return "add";

        }else{
            List<Ingredient> ingredients = (List<Ingredient>) ingredientRepository.findAllById(ingredientIds);
            List<Tag> tags = (List<Tag>) tagRepository.findAllById(tagIds);

            for(int i = 0; i<ingredients.size(); i++){
                recipeIngredients.put(ingredients.get(i), ingredientAmounts.get(i));
            }

            newRecipe.setRecipeIngredients(recipeIngredients);
            newRecipe.setTags(tags);
        }
        recipeRepository.save(newRecipe);
        return "redirect:";
    }

}



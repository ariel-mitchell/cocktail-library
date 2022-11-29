package com.liftoff.cocktaillibrary.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liftoff.cocktaillibrary.models.*;
import com.liftoff.cocktaillibrary.models.data.IngredientRepository;
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

//    public void dropdownManager(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
//        try (PrintWriter out = response.getWriter()) {
//            String op = request.getParameter("operation");
//            if (op.equals("ingredientType")) {
//
//                List<IngredientType> ingredientTypes = Arrays.asList(IngredientType.values());
//                Gson json = new Gson();
//                String ingTypeList = json.toJson(ingredientTypes);
//                response.setContentType("text/html");
//                response.getWriter().write(ingTypeList);
//            } else if (op.equals("ingredient")) {
//
//
//                model.addAttribute("ingredients", ingredientRepository.findAll());
//                String ingredientType = request.getParameter("ingredientType");
//                List<Ingredient> ingredients = RecipeData.findByType(ingredientType, ingredientRepository.findAll());
//                Gson json = new Gson();
//                String ingredientTypeList = json.toJson(ingredients);
//                response.setContentType("text/html");
//                response.getWriter().write(ingredientTypeList);
//            }
//        }
//
//    }

//    @GetMapping("getIngredientsByType")
//    public @ResponseBody String getIngredientsByType(@RequestParam String ingredientType){
//        String json = null;
//        ArrayList<Ingredient> list = RecipeData.findByType(ingredientType, ingredientRepository.findAll());
//        try {
//            json = new ObjectMapper().writeValueAsString(list);
//        }catch (JsonProcessingException e){
//            e.printStackTrace();
//        }
//        return json;
//    }

    @GetMapping("add")
    public String displayCreateRecipeForm(Model model){
        model.addAttribute("title", "Create Recipe");
        model.addAttribute("tags", tagRepository.findAll());
        List<IngredientType> ingredientTypes = Arrays.asList(IngredientType.values());
        model.addAttribute("ingredientTypes", ingredientTypes);

        model.addAttribute("ingredients", ingredientRepository.findAll());
        List<IngredientAmount> ingredientAmounts = Arrays.asList(IngredientAmount.values());
        model.addAttribute("ingredientAmounts", ingredientAmounts);

//        @RequestParam(required = false, name="ingredientType") IngredientType ingredientType)
//        List<Ingredient> ingredients = RecipeData.findByType(ingredientType, ingredientRepository.findAll());
//        model.addAttribute("ingredients",ingredients);

        return "add";
    }

    @PostMapping("add")
    public String processAddJobForm(@ModelAttribute @Valid Recipe newRecipe,
                                    Errors errors, Model model, @RequestParam List<Ingredient> ingredients, @RequestParam ArrayList<IngredientAmount> ingredientAmounts, @RequestParam List<Tag> tags) {

         HashMap<Ingredient, IngredientAmount> recipeIngredients = new HashMap<>();

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Recipe");
            return "add";

        }else{
            for(int i = 0; i<ingredients.size(); i++){
                recipeIngredients.put(ingredients.get(i), ingredientAmounts.get(i));
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



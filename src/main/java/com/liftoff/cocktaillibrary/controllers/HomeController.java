package com.liftoff.cocktaillibrary.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liftoff.cocktaillibrary.models.Ingredient;
import com.liftoff.cocktaillibrary.models.IngredientType;
import com.liftoff.cocktaillibrary.models.RecipeData;
import com.liftoff.cocktaillibrary.models.data.IngredientRepository;
import com.liftoff.cocktaillibrary.models.data.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.google.gson.Gson;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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

    @GetMapping("getIngredientsByType")
    public @ResponseBody String getIngredientsByType(@RequestParam String ingredientType){
        String json = null;
        ArrayList<Ingredient> list = RecipeData.findByType(ingredientType, ingredientRepository.findAll());
        try {
            json = new ObjectMapper().writeValueAsString(list);
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }
        return json;
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



package com.liftoff.cocktaillibrary.controllers;

import com.liftoff.cocktaillibrary.models.IngredientType;
import com.liftoff.cocktaillibrary.models.data.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @Autowired
    private TagRepository tagRepository;

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
    public String displayCreateRecipeForm(Model model, @RequestParam("ingredientType")IngredientType ingredientTypes){
        model.addAttribute("title", "Create Recipe");
        model.addAttribute("tags", tagRepository.findAll());
        model.addAttribute("ingredientType", ingredientTypes);
        return "add";
    }

    @PostMapping("add-account")
    public String processAddAccountForm(Model model) {
        return "redirect:";
    }
}



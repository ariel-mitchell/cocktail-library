package com.liftoff.cocktaillibrary.controllers;

import com.liftoff.cocktaillibrary.models.Tag;
import com.liftoff.cocktaillibrary.models.data.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


@Controller
@RequestMapping("tags")
public class TagController {

    @Autowired
    private TagRepository tagRepository;

    @GetMapping("")
    public String index(Model model){
        model.addAttribute("title", "Tag");
        model.addAttribute("tags", tagRepository.findAll());
        return "/tags";
    }

    @GetMapping("add")
    public String displayAddTagForm(Model model){
        model.addAttribute(new Tag());
        return "tags/add";
    }

    @PostMapping("add")
    public String processAddTagForm(@ModelAttribute @Valid Tag newTag, Errors errors, Model model){
        if (errors.hasErrors()){
            return "tags/add";
        }else{
            tagRepository.save(newTag);
            return"redirect:";
        }
    }
}

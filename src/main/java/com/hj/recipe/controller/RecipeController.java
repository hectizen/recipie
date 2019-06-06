package com.hj.recipe.controller;

import com.hj.recipe.domain.Recipe;
import com.hj.recipe.service.RecipeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
public class RecipeController {
    private final RecipeService recipeService;

    @RequestMapping("/recipe/show/{id}")
    public String showById(@PathVariable Long id, Model model ){
        Recipe recipe = recipeService.findById(id);
        model.addAttribute("recipe", recipe);
        return "/recipe/show";
    }
}

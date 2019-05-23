package com.hj.recipe.controller;

import com.hj.recipe.domain.Category;
import com.hj.recipe.domain.Recipe;
import com.hj.recipe.domain.UnitOfMeasure;
import com.hj.recipe.repository.CategoryRepository;
import com.hj.recipe.repository.RecipeRepository;
import com.hj.recipe.repository.UnitOfMeasureRepository;
import com.hj.recipe.service.RecipeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@AllArgsConstructor
public class IndexController {
    private final RecipeService recipeService;

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String index(Model model){
        model.addAttribute("recipes",recipeService.getRecipes());
        return "index";
    }
}

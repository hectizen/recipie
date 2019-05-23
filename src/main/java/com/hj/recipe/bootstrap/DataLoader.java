package com.hj.recipe.bootstrap;

import com.hj.recipe.domain.*;
import com.hj.recipe.repository.CategoryRepository;
import com.hj.recipe.repository.RecipeRepository;
import com.hj.recipe.repository.UnitOfMeasureRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Component
@AllArgsConstructor
public class DataLoader implements CommandLineRunner {
    private RecipeRepository recipeRepository;
    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    @Override
    public void run(String... args) throws Exception {
        loadData();
    }

    private void loadData() throws Exception{
        {
            Category category = categoryRepository.findByDescription("Korean").get();

            //categories.
            Set<Category> categories = new HashSet<>();
            categories.add(category);

            Recipe recipe = new Recipe();
            recipe.setCategories(categories);
            recipe.setCookTime(30);
            recipe.setDescription("Scallop potato. Yummy");
            recipe.setDifficulty(Difficulty.EASY);
            recipe.setDirections("Cook well");
            //
            // Ingredients
            //
            Set<Ingredient> ingredients = new HashSet<>();
            Ingredient ingredient = new Ingredient();
            ingredient.setAmount(new BigDecimal(2.0));
            ingredient.setDescription("Potato");
            ingredient.setRecipe(recipe);
            ingredient.setUom(unitOfMeasureRepository.findById(1L).get());
            ingredients.add(ingredient);

            ingredient = new Ingredient();
            ingredient.setAmount(new BigDecimal(0.45));
            ingredient.setDescription("Cream");
            ingredient.setRecipe(recipe);
            ingredient.setUom(unitOfMeasureRepository.findById(2L).get());
            ingredients.add(ingredient);

            recipe.setIngredients(ingredients);
            //
            // notes
            //
            Notes notes = new Notes();
            notes.setRecipeNotes("Good recipe");
            notes.setRecipie(recipe);
            recipe.setNotes(notes);

            recipe.setPrepTime(10);
            recipe.setServings(4);
            recipe.setSource("From me");
            recipe.setUrl("http://www.tastes.com");
            recipeRepository.save(recipe);
        }

        {
            Category category = categoryRepository.findByDescription("American").get();

            //categories.
            Set<Category> categories = new HashSet<>();
            categories.add(category);

            Recipe recipe = new Recipe();
            recipe.setCategories(categories);
            recipe.setCookTime(30);
            recipe.setDescription("Noraml potato. Yummy");
            recipe.setDifficulty(Difficulty.EASY);
            recipe.setDirections("Cook well");
            //
            // Ingredients
            //
            Set<Ingredient> ingredients = new HashSet<>();
            Ingredient ingredient = new Ingredient();
            ingredient.setAmount(new BigDecimal(2.0));
            ingredient.setDescription("Potato");
            ingredient.setRecipe(recipe);
            ingredient.setUom(unitOfMeasureRepository.findById(1L).get());
            ingredients.add(ingredient);

            ingredient = new Ingredient();
            ingredient.setAmount(new BigDecimal(0.45));
            ingredient.setDescription("Cream");
            ingredient.setRecipe(recipe);
            ingredient.setUom(unitOfMeasureRepository.findById(2L).get());
            ingredients.add(ingredient);

            recipe.setIngredients(ingredients);
            //
            // notes
            //
            Notes notes = new Notes();
            notes.setRecipeNotes("Good recipe");
            notes.setRecipie(recipe);
            recipe.setNotes(notes);

            recipe.setPrepTime(10);
            recipe.setServings(4);
            recipe.setSource("From me");
            recipe.setUrl("http://www.tastes.com");
            recipeRepository.save(recipe);
        }
    }
}

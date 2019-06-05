package com.hj.recipe.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(exclude = {"ingredients","image", "notes", "categories"})
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;
    private String directions;
    @Enumerated(value = EnumType.STRING)
    private Difficulty difficulty;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Set<Ingredient> ingredients;
    @Lob
    private Byte[] image;
    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes;
    @ManyToMany
    @JoinTable(name="recipe_category",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "categroy_id"))
    private Set<Category> categories;

    public void addNotes(Notes notes){
        if(notes != null) notes.setRecipie(this);
        this.notes = notes;
    }

    public void addIngredient(Ingredient ingredient){
        if(this.ingredients == null)
            this.ingredients = new HashSet<>();
        if(ingredient != null){
            ingredient.setRecipe(this);
            this.ingredients.add(ingredient);
        }
    }

    public void addCategory(Category category){
        if(this.categories == null)
            this.categories = new HashSet<>();
        if(category == null) return;
        this.categories.add(category);
     }
}

package com.hj.recipe.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Notes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Recipe recipie;
    @Lob
    private String recipeNotes;
}

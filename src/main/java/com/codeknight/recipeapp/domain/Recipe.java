package com.codeknight.recipeapp.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String description;

    private Integer prepTime;

    private String cookTime;

    private Integer servings;

    private String source;

    private String url;

    private String directions;

    @Enumerated(value = EnumType.STRING)
    private Difficulty difficulty;

    @Lob
    private Byte[] image;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Notes notes;

    @OneToMany(mappedBy = "recipe", fetch = FetchType.EAGER)
    private Set<Ingredient> ingredients;

    @ManyToMany
    @JoinTable(
            name = "recipe-category",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> categories;
}

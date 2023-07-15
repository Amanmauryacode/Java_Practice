package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Integer> {

}

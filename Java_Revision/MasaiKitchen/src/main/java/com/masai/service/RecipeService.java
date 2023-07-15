package com.masai.service;

import java.util.List;

import com.masai.ecxeption.RecipeException;
import com.masai.ecxeption.UserException;
import com.masai.model.Recipe;
import com.masai.model.UserReview;

public interface RecipeService {

	public Recipe createNewRecipe(String uuid, Recipe recipe) throws RecipeException, UserException;

	public Recipe getRecipeById(Integer id) throws RecipeException;

	public List<Recipe> getAllRecipes() throws RecipeException;

	public Recipe updateRecipe(String uuid, Recipe recipe) throws RecipeException, UserException;

	public Recipe deleteRecipeById(String uuid, Integer id) throws RecipeException, UserException;

	public String bookmarkRecipe(String uuid, Integer recipeId)throws RecipeException, UserException;
	
	public String rateRecipe(String uuid, Integer recipeId, UserReview review) throws RecipeException, UserException;

}

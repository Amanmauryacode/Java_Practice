package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.ecxeption.RecipeException;
import com.masai.ecxeption.UserException;
import com.masai.model.Recipe;
import com.masai.model.UserReview;
import com.masai.service.RecipeService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin("*")
public class RecipeController {

	@Autowired
	private RecipeService recipeService;

	@PostMapping("/recipes/{uuid}")
	public ResponseEntity<Recipe> createNewRecipe(@Valid @PathVariable String uuid, @RequestBody Recipe recipe)
			throws RecipeException, UserException {

		Recipe r = recipeService.createNewRecipe(uuid, recipe);
		return new ResponseEntity<>(r, HttpStatus.CREATED);
	}

	@GetMapping("recipes/{recipeId}")
	public ResponseEntity<Recipe> getRecipeById(@PathVariable("recipeId") Integer id) throws RecipeException {
		Recipe r = recipeService.getRecipeById(id);
		return new ResponseEntity<>(r, HttpStatus.OK);
	}

	@GetMapping("recipes")
	public ResponseEntity<List<Recipe>> getAllRecipes() throws RecipeException {
		List<Recipe> recipes = recipeService.getAllRecipes();
		return new ResponseEntity<>(recipes, HttpStatus.OK);
	}

	@PutMapping("/recipes/update/{uuid}")
	public ResponseEntity<Recipe> updateRecipe(@Valid @PathVariable("uuid") String uuid, @RequestBody Recipe recipe)
			throws RecipeException, UserException {
		Recipe r = recipeService.updateRecipe(uuid, recipe);
		return new ResponseEntity<>(r, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/recipes/{uuid}/{recipeId}")
	public ResponseEntity<Recipe> deleteRecipeById(@PathVariable("uuid") String uuid,
			@PathVariable("recipeId") Integer id) throws RecipeException, UserException {
		Recipe r = recipeService.deleteRecipeById(uuid, id);
		return new ResponseEntity<>(r, HttpStatus.ACCEPTED);
	}

	@PutMapping("recipes/bookmark/{uuid}")
	public ResponseEntity<String> bookmarkRecipe(@PathVariable("uuid") String uuid,
			@RequestParam("recipeId") Integer recipeId) throws RecipeException, UserException {
		String msg = recipeService.bookmarkRecipe(uuid, recipeId);
		return new ResponseEntity<>(msg, HttpStatus.ACCEPTED);
	}

	@PutMapping("recipes/review/{uuid}")
	public ResponseEntity<String> rateRecipe(@Valid @PathVariable("uuid") String uuid,
			@RequestParam("recipeId") Integer recipeId, @RequestBody UserReview review)
			throws RecipeException, UserException {
		String msg = recipeService.rateRecipe(uuid, recipeId, review);
		return new ResponseEntity<>(msg, HttpStatus.ACCEPTED);
	}

}

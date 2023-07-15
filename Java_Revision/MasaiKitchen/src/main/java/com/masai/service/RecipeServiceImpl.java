package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.ecxeption.RecipeException;
import com.masai.ecxeption.UserException;
import com.masai.model.CurrentUserSession;
import com.masai.model.Recipe;
import com.masai.model.User;
import com.masai.model.UserReview;
import com.masai.repository.RecipeRepository;
import com.masai.repository.SessionRepository;
import com.masai.repository.UserRepository;

@Service
public class RecipeServiceImpl implements RecipeService {

	@Autowired
	private RecipeRepository recipeRepo;

	@Autowired
	private SessionRepository sessionRepo;

	@Autowired
	private UserRepository userRepo;

	@Override
	public Recipe createNewRecipe(String uuid, Recipe recipe) throws RecipeException, UserException {

		CurrentUserSession cus = sessionRepo.findByUuid(uuid);

		if (cus == null)
			throw new UserException("User not Login into system");

		Optional<User> opt = userRepo.findById(cus.getUserId());
		if (opt.isEmpty())
			throw new UserException("User not Found in record");
		User user = opt.get();
		if (user.isAuthorized()) {
			return recipeRepo.save(recipe);
		}
		throw new UserException("User not Authorized");
	}

	@Override
	public Recipe getRecipeById(Integer id) throws RecipeException {
		Optional<Recipe> opt = recipeRepo.findById(id);
		if (opt.isEmpty())
			throw new RecipeException("Recipe not found in record!");

		return opt.get();
	}

	@Override
	public List<Recipe> getAllRecipes() throws RecipeException {
		List<Recipe> recipes = recipeRepo.findAll();
		if (recipes.isEmpty())
			throw new RecipeException("No Recipes found in record!");

		return recipes;
	}

	@Override
	public Recipe updateRecipe(String uuid, Recipe recipe) throws RecipeException, UserException {
		CurrentUserSession cus = sessionRepo.findByUuid(uuid);

		if (cus == null)
			throw new UserException("User not Login into system");

		Optional<User> opt = userRepo.findById(cus.getUserId());
		if (opt.isEmpty())
			throw new UserException("User not Found in record");
		User user = opt.get();
		if (user.isAuthorized()) {
			Optional<Recipe> opt1 = recipeRepo.findById(recipe.getId());
			if (opt1.isEmpty()) {
				throw new RecipeException("No Recipe found in record!");
			}
			return recipeRepo.save(recipe);
		}
		throw new UserException("User not Authorized");
	}

	@Override
	public Recipe deleteRecipeById(String uuid, Integer id) throws RecipeException, UserException {
		CurrentUserSession cus = sessionRepo.findByUuid(uuid);

		if (cus == null)
			throw new UserException("User not Login into system");

		Optional<User> opt = userRepo.findById(cus.getUserId());
		if (opt.isEmpty())
			throw new UserException("User not Found in record");
		User user = opt.get();
		if (user.isAuthorized()) {
			Optional<Recipe> opt1 = recipeRepo.findById(id);
			if (opt1.isEmpty()) {
				throw new RecipeException("No Recipe found in record!");
			}
			recipeRepo.delete(opt1.get());
			return opt1.get();
		}
		throw new UserException("User not Authorized");
	}

	@Override
	public String bookmarkRecipe(String uuid, Integer recipeId) throws RecipeException, UserException {
		CurrentUserSession cus = sessionRepo.findByUuid(uuid);

		if (cus == null)
			throw new UserException("User not Login into system");

		Optional<User> opt = userRepo.findById(cus.getUserId());
		if (opt.isEmpty())
			throw new UserException("User not Found in record");
		User user = opt.get();
		Optional<Recipe> opt1 = recipeRepo.findById(recipeId);
		if (opt1.isEmpty()) {
			throw new RecipeException("No Recipe found in record!");
		}
		user.getFavorite().add(opt1.get());
		userRepo.save(user);
		return "Successfully Added";
	}

	@Override
	public String rateRecipe(String uuid, Integer recipeId, UserReview review) throws RecipeException, UserException {
		CurrentUserSession cus = sessionRepo.findByUuid(uuid);

		if (cus == null)
			throw new UserException("User not Login into system");

		Optional<User> opt = userRepo.findById(cus.getUserId());
		if (opt.isEmpty())
			throw new UserException("User not Found in record");
		Optional<Recipe> opt1 = recipeRepo.findById(recipeId);
		if (opt1.isEmpty()) {
			throw new RecipeException("No Recipe found in record!");
		}
		Recipe recipe = opt1.get();
		recipe.getUserReview().add(review);
		recipeRepo.save(recipe);
		return "Successfully Reviewed!";
	}

}

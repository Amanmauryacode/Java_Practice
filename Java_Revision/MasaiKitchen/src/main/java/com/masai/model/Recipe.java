package com.masai.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Recipe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotNull(message = "Title required")
	@NotBlank(message = "Title required")
	private String title;
	@NotNull(message = "Description required")
	@NotBlank(message = "Description required")
	private String description;
	@NotNull(message = "Ingredients required")
	@NotBlank(message = "Ingredients required")
	private String ingredients;
	@NotNull(message = "Instructions required")
	@NotBlank(message = "Instructions required")
	private String instructions;
	@NotNull(message = "Preparation Time required")
	@NotBlank(message = "Preparation Time required")
	private String preparationTime;
	@NotNull(message = "Difficulty Level required")
	@NotBlank(message = "Difficulty Level required")
	private String difficultyLevel;
	
	@ElementCollection
	@Embedded
	@JoinTable(name="User_Review",joinColumns=@JoinColumn(name="recipe_id"))
	@JsonProperty(access = Access.READ_ONLY)
	private List<UserReview> userReview = new ArrayList<>();
	
}

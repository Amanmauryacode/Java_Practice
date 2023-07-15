package com.masai.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserReview {
	@NotNull(message = "User id required")
	@NotBlank(message = "User id required")
	private Integer user_id;
	@NotNull(message = "Rating required")
	@NotBlank(message = "Rating required")
	private Double rating;
	@NotNull(message = "Feedback required")
	@NotBlank(message = "Feedback required")
	private String feedback;
}

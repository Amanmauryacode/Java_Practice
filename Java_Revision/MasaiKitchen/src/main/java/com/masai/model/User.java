package com.masai.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotNull(message = "Username required")
	@NotBlank(message = "Username required")
	private String username;
	@NotNull(message = "Password required")
	@NotBlank(message = "Password required")
	private String password;
	@NotNull(message = "Email required")
	@NotBlank(message = "Email required")
	private String email;
	@JsonProperty(access = Access.READ_ONLY)
	private LocalDate registrationDate;
	@NotNull(message = "Authorized required")
	private boolean isAuthorized;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "userId")
	@JsonProperty(access = Access.READ_ONLY)
	private List<Recipe> favorite = new ArrayList<>();
}

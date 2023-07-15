package com.masai.DTO;

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
public class LoginDTO {
	@NotNull(message = "User Name required")
	@NotBlank(message = "User Name required")
	private String userName;
	@NotNull(message = "Password required")
	@NotBlank(message = "Password required")
	private String password;
}

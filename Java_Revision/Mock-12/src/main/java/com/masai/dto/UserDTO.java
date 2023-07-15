package com.masai.dto;

import com.masai.entity.Role;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
	
	@NotNull(message = "User name must be required")
	private String userName;
	@NotNull(message = "Password must be required")
	private String password;
	@NotNull(message = "Address must be required")
	private String address;
	@Enumerated(EnumType.STRING)
	private Role role;
}

package com.masai.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class MasaiSecurityConfig {
	@Bean
	public SecurityFilterChain securityConfig(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests((auth) -> auth.requestMatchers("/mock-10/welcomePofile").authenticated()
				.requestMatchers("/mock-10/admin").hasRole("ADMIN")
				.requestMatchers("/mock-10/welcome", "/mock-10/user/register").permitAll()

		).csrf().disable().httpBasic();

		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
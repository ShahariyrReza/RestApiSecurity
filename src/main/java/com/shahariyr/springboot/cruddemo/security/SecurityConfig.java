package com.shahariyr.springboot.cruddemo.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	/*
	 * This bean is for defining user details by coding..
	 * here {noop} means no operation in password.It will not be encrypted.
	 * 
	 * @Bean 
	 * InMemoryUserDetailsManager InMemoryUserDetailsManager() {
	 * 
	 * UserDetails shahariyr = User.builder() .username("shahariyr")
	 * .password("{noop}1nc0rr3c7") .roles("EMPLOYEE") .build();
	 * 
	 * UserDetails mazher = User.builder() .username("mazher")
	 * .password("{noop}1nc0rr3c7") .roles("EMPLOYEE","MANAGER") .build();
	 * 
	 * UserDetails maksud = User.builder() .username("maksud")
	 * .password("{noop}1nc0rr3c7") .roles("EMPLOYEE","MANAGER","ADMIN") .build();
	 * return new InMemoryUserDetailsManager(shahariyr,mazher,maksud); }
	 */

// This bean is for read user data and their roll from database plain text.

	@Bean
	UserDetailsManager userDetailsManager(DataSource dataSource) {
		return new JdbcUserDetailsManager(dataSource);
	}

// For role based authentication to get or modify database.

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests(configurer -> configurer.requestMatchers(HttpMethod.GET, "/api/employees")
				.hasRole("EMPLOYEE").requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
				.requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
				.requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
				.requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")

		);
		// http basic authentication;
		http.httpBasic(Customizer.withDefaults());

		// Disable CSRF because it not necessary for PUT.POST,DELETE and/or PATCH;
		http.csrf(csrf -> csrf.disable());

		return http.build();

	}

}

package com.shahariyr.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {

	@Bean
	InMemoryUserDetailsManager InMemoryUserDetailsManager() {
		
		UserDetails shahariyr = User.builder()
				.username("shahariyr")
				.password("{noop}1nc0rr3c7")
				.roles("employee")
				.build();
		
		UserDetails mazher = User.builder()
				.username("mazher")
				.password("{noop}1nc0rr3c7")
				.roles("employee","manager")
				.build();
		
		UserDetails maksud = User.builder()
				.username("maksud")
				.password("{noop}1nc0rr3c7")
				.roles("employee","maager","CEO")
				.build();
		return new InMemoryUserDetailsManager(shahariyr,mazher,maksud);
 	}

}

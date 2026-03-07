package com.springboot.springsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@SpringBootApplication
public class SpringsecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringsecurityApplication.class, args);
	}

	@Bean
	public SecurityFilterChain security(HttpSecurity http) {
		http
			.csrf(csrf->csrf.disable())
			.authorizeHttpRequests(auth->auth
					.requestMatchers("/customer/**").hasRole("USER")
					.requestMatchers("/admin/**").hasAnyRole("ADMIN")
					.anyRequest().authenticated())
			.formLogin(form->form.permitAll())
			.logout(logout->logout.permitAll());
			
		return http.build();
			
	}
	
	@Bean
	public UserDetailsService users() {
		
		var user=User.withUsername("rony")
				.password("{noop}rony20")
				.roles("USER")
				.build();
		var admin=User.withUsername("admin")
				.password("{noop}admin@123")
				.roles("ADMIN")
				.build();
		
		return new InMemoryUserDetailsManager(user,admin);
	}
}

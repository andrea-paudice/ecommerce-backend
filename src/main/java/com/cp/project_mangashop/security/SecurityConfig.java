package com.cp.project_mangashop.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.cp.project_mangashop.service.impl.CustomUserDetailsServiceImpl;

@Configuration
public class SecurityConfig {

	@Autowired
    private CustomUserDetailsServiceImpl userDetailsService;

	@Autowired
    private JwtAuthenticationFilter jwtFilter;
	
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                                //.anyRequest().permitAll()
                				.requestMatchers("/users/register", "/users/login", "/public/**", "/products/**", "/products/update/**", "/users/**").permitAll() // accesso libero
                                .requestMatchers("/admin/**", "/orders/admin/all", "/users/profile").hasRole("ADMIN") // solo admin
                                .anyRequest().authenticated() // tutti gli altri endpoint richiedono login
                )
                .userDetailsService(userDetailsService)
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}

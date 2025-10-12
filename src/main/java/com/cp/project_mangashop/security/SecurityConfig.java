package com.cp.project_mangashop.security;


import java.util.List;

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
import org.springframework.web.cors.CorsConfiguration;

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
                .cors(cors -> cors.configurationSource(request -> {
                    var corsConfig = new CorsConfiguration();
                    corsConfig.setAllowedOrigins(List.of("http://localhost:3000"));
                    corsConfig.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
                    corsConfig.setAllowedHeaders(List.of("Authorization", "Content-Type"));
                    corsConfig.setAllowCredentials(true);
                    return corsConfig;
                }))
                .authorizeHttpRequests(auth -> auth
                                //.anyRequest().permitAll()
                				//.requestMatchers("/users/register", "/users/login", "/public/**", "/products/**", "/products/update/**", "/users/**").permitAll() // accesso libero
                                //.requestMatchers("/admin/**", "/orders/admin/all", "/users/profile").hasRole("ADMIN") // solo admin
                		.requestMatchers("/api/public/**").permitAll()
                		.requestMatchers("/api/user/**").hasRole("USER")
                		.requestMatchers("/api/admin/**").hasRole("ADMIN")
                                .anyRequest().authenticated() // tutti gli altri endpoint richiedono login
                )
                .userDetailsService(userDetailsService)
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}

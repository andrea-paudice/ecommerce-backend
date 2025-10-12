package com.cp.project_mangashop.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.security.SignatureException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");
        String username = null;
        String token = null;

        try {
            if (authHeader != null && authHeader.startsWith("Bearer ")) {
                token = authHeader.substring(7);
                username = jwtUtil.extractUsername(token);
            }

            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                var userDetails = userDetailsService.loadUserByUsername(username);

                if (jwtUtil.validateToken(token)) {
                    var authToken = new UsernamePasswordAuthenticationToken(
                            userDetails, null, userDetails.getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(authToken);
                }
            }

            chain.doFilter(request, response);

        } catch (ExpiredJwtException e) {
            System.out.println("⚠️ Token JWT scaduto per utente: " + e.getClaims().getSubject());
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Token scaduto, effettua nuovamente il login");

        } catch (SignatureException | MalformedJwtException e) {
            System.out.println("⚠️ Token JWT non valido: " + e.getMessage());
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Token non valido");

        } catch (Exception e) {
            System.out.println("❌ Errore nella validazione JWT: " + e.getMessage());
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Errore autenticazione JWT");
        }
    }
}

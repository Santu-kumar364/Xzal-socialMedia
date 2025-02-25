package com.socialMedia.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class jwtValidator extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String jwt = request.getHeader(JwtConstant.JWT_HEADER);

        if (jwt != null) {
            try {
                // Extract email from the JWT token
                String email = JwtProvider.getEmailFromJwtToken(jwt);

                // Create an empty list of authorities (or populate if needed)
                List<GrantedAuthority> authorities = new ArrayList<>();

                // Create an authentication token
                org.springframework.security.core.Authentication authentication = 
                    new UsernamePasswordAuthenticationToken(email, null, authorities);

                // Set the authentication in the security context
                SecurityContextHolder.getContext().setAuthentication(authentication);

            } catch (Exception e) {
                throw new BadCredentialsException("Invalid token.");
            }
        }

        // Proceed with the filter chain
        filterChain.doFilter(request, response);
    }
}

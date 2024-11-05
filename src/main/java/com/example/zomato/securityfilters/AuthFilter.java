package com.example.zomato.securityfilters;

import com.example.zomato.enums.UserRole;
import com.example.zomato.security.JWTService;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@AllArgsConstructor
@Slf4j
public class AuthFilter extends OncePerRequestFilter {


    private final JWTService jwtService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("Authorization");
        if (token != null) {
            log.info("Authenticating Token...");
            token = token.substring(7);

            Claims claims = jwtService.extractClaims(token);
            String username = jwtService.getUsername(claims);
            String role= jwtService.getRole(claims);


            if (username != null) {
                log.info("Username extracted");
                //UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken= new UsernamePasswordAuthenticationToken(username, null, List.of(new SimpleGrantedAuthority(role)));

                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken
                        = new UsernamePasswordAuthenticationToken(username, null, UserRole.valueOf(role)
                                                                                                   .getPrivileges()
                                                                                                   .stream()
                                                                                                   .map(privilege -> new SimpleGrantedAuthority(privilege.name()))
                                                                                                    .toList());
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                log.info("Token Authentication successful.");
            }
        }

        filterChain.doFilter(request,response);

    }
}

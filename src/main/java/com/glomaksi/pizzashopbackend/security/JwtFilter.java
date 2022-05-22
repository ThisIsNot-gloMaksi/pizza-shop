package com.glomaksi.pizzashopbackend.security;

import com.glomaksi.pizzashopbackend.entity.User;
import com.glomaksi.pizzashopbackend.exception.notfound.UserNotFoundException;
import com.glomaksi.pizzashopbackend.service.user.UserService;
import com.glomaksi.pizzashopbackend.utils.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class JwtFilter extends GenericFilterBean {
    private final UserService userService;
    @Value("#{environment.JWT_SECRET_KEY}")
    private String secret;
    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws ServletException, IOException {
        String headerValue = ((HttpServletRequest)servletRequest).getHeader("Authorization");
        Optional<String> optionalToken = JwtUtils.getBearerToken(headerValue);

        optionalToken.ifPresent(token -> {

            if (JwtUtils.isJwtExpired(token, secret) && JwtUtils.validateToken(token, secret)) {
                return;
            }

            String name = JwtUtils.getNameFromToken(token, secret);
            try {
                User user = userService.getUserByName(name);
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                        new UsernamePasswordAuthenticationToken(user,
                                null,
                                user.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

            } catch (UserNotFoundException ex) {
                System.out.println(ex.getMessage());
            }
        });
        filterChain.doFilter(servletRequest, servletResponse);
    }
}

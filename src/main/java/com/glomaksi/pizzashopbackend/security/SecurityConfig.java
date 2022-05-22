package com.glomaksi.pizzashopbackend.security;

import com.glomaksi.pizzashopbackend.entity.RoleConstant;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final JwtFilter jwtFilter;
    private final String ADMIN = RoleConstant.ADMIN.toString();
    private final String SIMPLE_USER = RoleConstant.SIMPLE_USER.toString();

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .httpBasic().disable()
                .cors().disable()
                .authorizeRequests()
                    .antMatchers("/auth/v1/login").permitAll()
                    .antMatchers(HttpMethod.GET, "/api/v1/**").permitAll()
                    .antMatchers(HttpMethod.GET, "/api/v1/admin/**").hasRole(ADMIN)
                .anyRequest().authenticated();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

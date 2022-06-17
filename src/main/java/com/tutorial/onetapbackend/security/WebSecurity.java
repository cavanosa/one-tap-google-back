package com.tutorial.onetapbackend.security;

import com.tutorial.onetapbackend.security.jwt.JwtEntryPoint;
import com.tutorial.onetapbackend.security.jwt.JwtFilter;
import com.tutorial.onetapbackend.security.jwt.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class WebSecurity {

    @Autowired
    JwtProvider jwtProvider;

    @Autowired
    JwtEntryPoint jwtEntryPoint;

    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.cors();
        http.authorizeRequests().anyRequest().authenticated();
        http.exceptionHandling().authenticationEntryPoint(jwtEntryPoint);
        http.addFilterBefore(new JwtFilter(), BasicAuthenticationFilter.class);
        http.authenticationProvider(jwtProvider);
        return http.build();
    }
}

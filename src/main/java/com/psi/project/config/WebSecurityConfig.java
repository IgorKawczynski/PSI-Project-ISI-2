package com.psi.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class WebSecurityConfig {

    private static final String ADMIN = "ADMIN";
    private static final String CLIENT = "CLIENT";

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails client = User
                .withUsername("client")
                .password(passwordEncoder().encode("password"))
                .roles(CLIENT)
                .build();

        UserDetails admin = User
                .withUsername("admin")
                .password(passwordEncoder().encode("password"))
                .roles(ADMIN)
                .build();

        return new InMemoryUserDetailsManager(client, admin);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    // CSRF wyłączony dla puszczania POST'ÓW
    // AKTUALNIE DOSTĘP DO RESTÓW ZWIĄZANYCH Z ITEMS I ADDRESS MA KLIENT
    // DOSTĘP DO RESTÓW ZWIĄZANYCH Z USERS MA TYLKO ADMIN

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/auth/login").permitAll()
                .antMatchers("/items/**").hasAnyRole("CLIENT")
                .antMatchers("/address/**").hasAnyRole("CLIENT")
                .antMatchers("/users/**").hasAnyRole("ADMIN")
                .antMatchers("/graphiql/**").hasAnyRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/auth/logout"))
                .and()
                .build();
    }
}
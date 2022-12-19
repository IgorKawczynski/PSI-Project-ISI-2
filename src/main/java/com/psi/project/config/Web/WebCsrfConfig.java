package com.psi.project.config.Web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class WebCsrfConfig {

    // PO WYKASOWANIU PONIŻSZEJ METODY UAKTYWNI SIĘ PANEL LOGOWANIA
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//           .csrf()
//           .disable();
//    }


    // CONFIG POD AUTENTYFIKACJE

//    public class WebCsrfConfig extends WebSecurityConfigurerAdapter {

//    private static final String[] AUTH_WHITELIST = {
//            "/v2/api-docs",
//            "/swagger-resources",
//            "/swagger-resources/**",
//            "/configuration/ui",
//            "/configuration/security",
//            "/swagger-ui.html",
//            "/webjars/**",
//            "/v3/api-docs/**",
//            "/swagger-ui/**",
//            "/address/**",
//            "/users",
//            "/users/**",
//            "/items/**",
//            "/**"
//    };

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers(AUTH_WHITELIST)
//                .permitAll()
//                .antMatchers("/tuUrlDoBlokowania").authenticated(); // dla reszty potrzeba autoryzacji (logowanie)
//    }

//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//           .csrf()
//           .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
//        return http.build();
//    }

//    @Bean
//    CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration configuration = new CorsConfiguration();
//        configuration.setAllowedOrigins(List.of("*"));
//        configuration.setAllowedMethods(List.of("*"));
//        configuration.setAllowedHeaders(List.of("*"));
//        configuration.setAllowCredentials(true);
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//        return source;
//    }
}

package com.sokchoys.config;

import static com.sokchoys.constant.SECURITY_SET.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            .csrf((csrf) -> csrf
                .disable()
            )

            .formLogin((login) -> login
                .disable()
            )

            .httpBasic((basic) -> basic
                .disable()
            )

            .oauth2Login(
                Customizer.withDefaults()
            )

            .authorizeHttpRequests((auth) -> auth
                .requestMatchers(PERMITALL_URL_PATTERNS).permitAll()
                .requestMatchers(NEED_LOGIN_URL_PATTERNS).authenticated()
                .requestMatchers(NEED_ADMIN_ROLE_URL_PATTERNS).hasRole("ADMIN")
                .anyRequest().permitAll()
            );

        return http.build();
    }
}

package com.fiap.app.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {
        @Bean
        public PasswordEncoder passwordEncoder() {
                return new BCryptPasswordEncoder();
        }

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
                http.authorizeHttpRequests((authz) -> authz
                .requestMatchers("/api/home/**").permitAll()
                .anyRequest().authenticated())
                .formLogin();
                return http.build();
        }

      

        @Bean
        public UserDetailsService userDetailsService() {
                UserDetails user = User.builder()
                                .username("user")
                                .password(passwordEncoder().encode("password"))
                                .roles("USER")
                                .build();

                return new InMemoryUserDetailsManager(user);
        }

}
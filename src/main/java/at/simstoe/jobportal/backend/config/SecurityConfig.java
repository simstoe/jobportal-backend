package at.simstoe.jobportal.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf().disable()
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/public/**").permitAll() // Allow public access to specific endpoints
                        .requestMatchers("/admin/**").hasRole("ADMIN") // Restrict access to admin endpoints
                        .requestMatchers(HttpMethod.POST, "/api/**").permitAll() // Allow POST requests to /api/**
                        .anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults()).build();
    }

    @Bean
    public UserDetailsService userDetails() {
        var user = User.builder()
                .passwordEncoder(passwordEncoder()::encode)
                .username("Test12345_")
                .password("Test12345_")
                .roles("USER") // Assign the USER role to the default user
                .build();

        return new InMemoryUserDetailsManager(user);
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        var defaultID = "argon2id";
        Map<String, PasswordEncoder> encoderMap = new HashMap<>();

        encoderMap.put("argon2id", new Argon2PasswordEncoder(16, 32, 1, 60000, 10));

        return new DelegatingPasswordEncoder(defaultID, encoderMap);
    }
}
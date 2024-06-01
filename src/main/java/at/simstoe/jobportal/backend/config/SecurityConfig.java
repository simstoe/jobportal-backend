package at.simstoe.jobportal.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        String defaultID = "argon2id";
        Map<String, PasswordEncoder> encoderMap = new HashMap<>();

        encoderMap.put("argon2id", new Argon2PasswordEncoder(16, 32, 1, 60000, 10));

        return new DelegatingPasswordEncoder(defaultID, encoderMap);
    }
}
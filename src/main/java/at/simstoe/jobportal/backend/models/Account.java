package at.simstoe.jobportal.backend.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Account {
    @Id
    @Column(nullable = false, updatable = false, unique = true)
    @SequenceGenerator(name = "account_sequence", sequenceName = "account_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_sequence")
    private Long id;

    @NotBlank
    @Size(max = 20)
    private String name;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(max = 150)
    private String password;

    @NotBlank
    @Size(max = 20)
    private String userRole;

    @Component
    public static class PasswordHasher {
        private static PasswordEncoder passwordEncoder;

        @Autowired
        public PasswordHasher(PasswordEncoder passwordEncoder) {
            PasswordHasher.passwordEncoder = passwordEncoder;
        }

        public static String encode(String password) {
            return passwordEncoder.encode(password);
        }
    }

    public void hashPassword() {
        this.password = PasswordHasher.encode(this.password);
    }
}

package at.simstoe.jobportal.backend.models;

import at.simstoe.jobportal.backend.models.enums.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;

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

    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    public void hashPassword() {
        Argon2PasswordEncoder argon2PasswordEncoder = new Argon2PasswordEncoder(16,32,1,60000,10);

        this.password = argon2PasswordEncoder.encode(this.password);
    }
}

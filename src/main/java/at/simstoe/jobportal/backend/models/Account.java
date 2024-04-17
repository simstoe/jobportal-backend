package at.simstoe.jobportal.backend.models;

import at.simstoe.jobportal.backend.models.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Account {
    private Long id;
    private String name;
    private String email;
    private String password;

    private UserRole userRole;

    public void hashPassword() {
        Argon2PasswordEncoder argon2PasswordEncoder = new Argon2PasswordEncoder(16,32,1,60000,10);

        this.password = argon2PasswordEncoder.encode(this.password);
    }
}

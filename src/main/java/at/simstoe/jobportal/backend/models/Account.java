package at.simstoe.jobportal.backend.models;

import at.simstoe.jobportal.backend.models.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Account {
    private Long id;
    private String name;
    private String email;
    private String password;

    private UserRole userRole;
}

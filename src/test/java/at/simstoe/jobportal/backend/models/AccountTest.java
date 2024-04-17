package at.simstoe.jobportal.backend.models;

import at.simstoe.jobportal.backend.models.enums.UserRole;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    Account account;
    Argon2PasswordEncoder argon2PasswordEncoder;

    @BeforeEach
    void setUp() {
        account = new Account(1L, "Test", "Test@test.com", "test", UserRole.USER);
        argon2PasswordEncoder = new Argon2PasswordEncoder(16,32,1,60000,10);
    }

    @AfterEach
    void tearDown() {
    }

    @ParameterizedTest
    @ValueSource(strings = {"Test", "Test123", "Test123!", "Test123!§$%&/()", "", "1234567890", "1234567890!"})
    void hashPassword(String password) {
        account.setPassword(password);
        account.hashPassword();

        assertTrue(argon2PasswordEncoder.matches(password, account.getPassword()));
    }

    @Test
    void hash() {
        account.hashPassword();
        System.out.println(account.getPassword());
    }
}
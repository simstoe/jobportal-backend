package at.simstoe.jobportal.backend.models;

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
        account = new Account(1L, "Test", "Test@test.com", "test", "Test");
        argon2PasswordEncoder = new Argon2PasswordEncoder(16,32,1,60000,10);
    }

    @AfterEach
    void tearDown() {
    }

    @ParameterizedTest
    @ValueSource(strings = {"Test", "Test123", "Test123!", "Test123!§$%&/()", "", "1234567890", "1234567890!"})
    void hashPassword(String password) {
        account.setPassword(password);
        //account.hashPassword();

        assertTrue(argon2PasswordEncoder.matches(password, account.getPassword()));

        //assertArrayEquals();
    }

    @Test
    void hash() {
        //account.hashPassword();
    }

    @Test
    void testSavedAccount() {
        //account.hashPassword();

        assertEquals(1L, account.getId());
        assertEquals("Test", account.getName());
        assertEquals("Test@test.com", account.getEmail());
        //assertTrue(argon2PasswordEncoder.matches("test", account.getPassword()));
    }
}
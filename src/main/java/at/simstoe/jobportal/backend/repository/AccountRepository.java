package at.simstoe.jobportal.backend.repository;

import at.simstoe.jobportal.backend.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findAccountByEmail(String email);

    Account deleteAccountByEmail(String email);
}

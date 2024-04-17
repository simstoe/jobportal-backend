package at.simstoe.jobportal.backend.service;

import at.simstoe.jobportal.backend.models.Account;
import at.simstoe.jobportal.backend.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;

    public List<Account> getAllAccounts() {
        return this.accountRepository.findAll();
    }

    public Account getAccountByEmail(String email) {
        return this.accountRepository.findAccountByEmail(email);
    }

    public Account createAccount(Account account) {
        return this.accountRepository.save(account);
    }

    public Account updateAccount(Account account) {
        Account existingAccount = this.accountRepository.findById(account.getId()).orElse(null);

        assert existingAccount != null;
        existingAccount.setName(account.getName());
        existingAccount.setEmail(account.getEmail());
        existingAccount.setPassword(account.getPassword());

        return this.accountRepository.save(account);
    }

    public Account deleteAccountByEmail(String email) {
        Account account = this.accountRepository.findAccountByEmail(email);

        this.accountRepository.delete(account);

        return account;
    }

}

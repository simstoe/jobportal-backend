package at.simstoe.jobportal.backend.service;

import at.simstoe.jobportal.backend.models.Account;
import at.simstoe.jobportal.backend.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;

    public List<Account> getAllAccounts() {
        return this.accountRepository.findAll();
    }

    public Account createAccount(Account account) {
        if (this.accountRepository.findAccountByEmail(account.getEmail()) != null) return null;
        if (this.accountRepository.findAccountByName(account.getName()) != null) return null;

        return this.accountRepository.save(account);
    }

    public Account getAccountByEmail(String email) {
        return this.accountRepository.findAccountByEmail(email);
    }

    public Account getAccountByName(String name) {
        return this.accountRepository.findAccountByName(name);
    }

    public Account updateAccount(Account account) {
        Account existingAccount = this.accountRepository.findById(account.getId()).orElse(null);

        if (existingAccount == null) return null;
        existingAccount.setName(account.getName());
        existingAccount.setEmail(account.getEmail());
        existingAccount.setPassword(account.getPassword());

        return this.accountRepository.save(existingAccount);
    }

    @Transactional
    public boolean deleteAccountById(Long id) {
        if (this.accountRepository.findAccountById(id) == null) return false;
        this.accountRepository.deleteById(id);
        return true;
    }

    public Account getAccountById(Long id) {
        return this.accountRepository.findAccountById(id);
    }
}

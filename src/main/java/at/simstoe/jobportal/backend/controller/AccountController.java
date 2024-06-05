package at.simstoe.jobportal.backend.controller;

import at.simstoe.jobportal.backend.models.Account;
import at.simstoe.jobportal.backend.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/account")
@AllArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @GetMapping("/all")
    public ResponseEntity<List<Account>> getAllAccounts() {
        return ResponseEntity.ok(this.accountService.getAllAccounts());
    }

    @PostMapping("/create")
    public ResponseEntity<Account> addAccount(@RequestBody Account account) {
        if (this.accountService.getAccountByEmail(account.getEmail()) != null) return ResponseEntity.badRequest().build();
        if (this.accountService.getAccountByName(account.getName()) != null) return ResponseEntity.badRequest().build();

        return ResponseEntity.ok(this.accountService.createAccount(account));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Account> updateAccount(@PathVariable Long id, @RequestBody Account account) {
        var existingAccount = this.accountService.getAccountById(id);

        if (existingAccount == null) return ResponseEntity.badRequest().build();

        existingAccount.setName(account.getName());
        existingAccount.setEmail(account.getEmail());
        existingAccount.setPassword(account.getPassword());
        existingAccount.setUserRole(account.getUserRole());

        return ResponseEntity.ok(this.accountService.updateAccount(existingAccount));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable Long id) {
        var isDeleted = this.accountService.deleteAccountById(id);

        if (isDeleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

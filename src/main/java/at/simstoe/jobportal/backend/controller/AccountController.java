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
    public ResponseEntity<List<Account>> getAllAccount() {
        return ResponseEntity.ok(this.accountService.getAllAccounts());
    }

    @PostMapping("/create")
    public ResponseEntity<Account> addAccount(@RequestBody Account account) {
        return ResponseEntity.ok(this.accountService.createAccount(account));
    }

    @PutMapping("/update")
    public ResponseEntity<Account> updateAccount(@RequestBody Account account) {
        return ResponseEntity.ok(this.accountService.updateAccount(account));
    }

    @DeleteMapping("/delete/{email}")
    public ResponseEntity<Account> deleteAccount(@PathVariable String email) {
        return ResponseEntity.ok(this.accountService.deleteAccountByEmail(email));
    }
}

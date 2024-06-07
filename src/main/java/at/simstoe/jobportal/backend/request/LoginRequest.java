package at.simstoe.jobportal.backend.request;

import at.simstoe.jobportal.backend.models.Account;
import at.simstoe.jobportal.backend.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/login")
@RequiredArgsConstructor
public class LoginRequest {
    private final AccountService accountService;

    @GetMapping("/")
    public ResponseEntity<Boolean> login(@RequestBody Account account) {
        if (this.accountService.getAccountByEmail(account.getEmail()) == null) return ResponseEntity.notFound().build();

        var databaseAccount = this.accountService.getAccountByEmail(account.getEmail());

        if (databaseAccount.getEmail().equals(account.getEmail()) && databaseAccount.getPassword().equals(account.getPassword())) {
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}

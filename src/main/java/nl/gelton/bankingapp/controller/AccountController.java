package nl.gelton.bankingapp.controller;

import lombok.AllArgsConstructor;
import nl.gelton.bankingapp.dto.AccountDto;
import nl.gelton.bankingapp.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private AccountService accountService;

    // Add Account REST API
    @PostMapping
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto) {
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

    // Get Account By Id REST API
    @GetMapping("{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id) {
        AccountDto accountDto = accountService.getAccountById(id);
        return ResponseEntity.ok(accountDto);
    }

}

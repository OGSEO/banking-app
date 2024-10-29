package nl.gelton.bankingapp.service;

import nl.gelton.bankingapp.dto.AccountDto;

import java.util.List;

public interface AccountService {

    AccountDto createAccount(AccountDto accountDto);

    AccountDto getAccountById(Long id);

    List<AccountDto> getAllAccounts();

    void deleteAccount(Long id);

    AccountDto deposit(Long id, Double amount);

    AccountDto withdraw(Long id, Double amount);
}


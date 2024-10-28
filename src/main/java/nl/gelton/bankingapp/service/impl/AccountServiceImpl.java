package nl.gelton.bankingapp.service.impl;

import lombok.AllArgsConstructor;
import nl.gelton.bankingapp.dto.AccountDto;
import nl.gelton.bankingapp.entity.Account;
import nl.gelton.bankingapp.mapper.AccountMapper;
import nl.gelton.bankingapp.repository.AccountRepository;
import nl.gelton.bankingapp.service.AccountService;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }


}

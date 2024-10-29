package nl.gelton.bankingapp.service.impl;

import lombok.AllArgsConstructor;
import nl.gelton.bankingapp.dto.AccountDto;
import nl.gelton.bankingapp.entity.Account;
import nl.gelton.bankingapp.mapper.AccountMapper;
import nl.gelton.bankingapp.repository.AccountRepository;
import nl.gelton.bankingapp.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public AccountDto getAccountById(Long id) {
        Account account = accountRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Account does not exists"));
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
//        List<AccountDto> accountDtoList = accounts.stream().map(account -> AccountMapper.mapToAccountDto(account))
//               .collect(Collectors.toList());

//        List<AccountDto> accountDtoList = accounts.stream().map(AccountMapper::mapToAccountDto)
//                .toList();
//        return accountDtoList;
//    }

        return accounts.stream().map(AccountMapper::mapToAccountDto)
                .toList();
    }

    @Override
    public void deleteAccount(Long id) {
        Account account = accountRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Account does not exists"));
        accountRepository.deleteById(id);
    }

    @Override
    public AccountDto deposit(Long id, Double amount) {
        Account account = accountRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Account does not exists"));

        double total = account.getBalance() + amount;
        account.setBalance(total);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto withdraw(Long id, Double amount) {
        Account account = accountRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Account does not exists"));

        if(account.getBalance() < amount) {
            throw new RuntimeException("Insufficient balance");
        }

        double total = account.getBalance() - amount;
        account.setBalance(total);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }


}

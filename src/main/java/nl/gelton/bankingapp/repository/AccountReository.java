package nl.gelton.bankingapp.repository;

import nl.gelton.bankingapp.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountReository extends JpaRepository<Account, Long> {
}

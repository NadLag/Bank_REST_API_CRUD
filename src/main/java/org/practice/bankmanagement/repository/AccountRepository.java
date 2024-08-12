package org.practice.bankmanagement.repository;

import org.practice.bankmanagement.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

}

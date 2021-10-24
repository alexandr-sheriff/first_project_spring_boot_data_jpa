package com.alex.spring.service;

import com.alex.spring.entity.Account;
import com.alex.spring.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountService2 {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService2(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveAccount2() {
        Account account3 = new Account("Alex3", "alex3@mail.ru", 3333);
        accountRepository.save(account3);
    }

}

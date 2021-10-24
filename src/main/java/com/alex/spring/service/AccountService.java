package com.alex.spring.service;

import com.alex.spring.entity.Account;
import com.alex.spring.exception.AccountNotFoundException;
import com.alex.spring.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final AccountService2 accountService2;

    @Autowired
    public AccountService(AccountRepository accountRepository, AccountService2 accountService2) {
        this.accountRepository = accountRepository;
        this.accountService2 = accountService2;
    }

    @Transactional
    public Long createAccount(String name, String email, Integer bill) {
        Account account = new Account(name, email, bill);
        Account account1 = accountRepository.save(account);
        accountService2.saveAccount2();
        int a = 1 / 0;
        Account account2 = new Account("Alex2", "alex2@mail.ru", 2222);
        accountRepository.save(account2);
        return account1.getId();
    }



    public Long updateAccount(Long id, String name, String email, Integer bill) {
        if (id == null)
            throw new AccountNotFoundException("Can't find account with id: " + id);
        Account account = new Account(id, name, email, bill);
        return accountRepository.save(account).getId();
    }

    public Account getAccountById(Long id) {
        return accountRepository.findById(id).orElseThrow(() -> new AccountNotFoundException("Can't find account with id: " + id));
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Account deleteAccountById(Long id) {
        Account accountById = getAccountById(id);
        accountRepository.deleteById(id);
        return accountById;
    }
}

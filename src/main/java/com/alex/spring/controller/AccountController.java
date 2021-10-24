package com.alex.spring.controller;

import com.alex.spring.dto.AccountRequestDTO;
import com.alex.spring.dto.AccountResponseDTO;
import com.alex.spring.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }


    @GetMapping("/hello")
    public String helloSpring() {
        return "Hello Spring";
    }

    @GetMapping("/string")
    public String getString(
            @RequestParam(name = "ABC", required = false, defaultValue = "default") String line,
            @RequestParam(name = "scope", required = false, defaultValue = "test") String test
    ) {
        return "Hello Spring";
    }

    @PostMapping("/accounts")
    public Long createAccount(@RequestBody AccountRequestDTO accountRequestDTO) {
        return accountService.createAccount(accountRequestDTO.getName(), accountRequestDTO.getEmail(), accountRequestDTO.getBill());
    }

    @PutMapping("/accounts")
    public Long updateAccount(@RequestBody AccountRequestDTO accountRequestDTO) {
        return accountService.updateAccount(accountRequestDTO.getId(), accountRequestDTO.getName(), accountRequestDTO.getEmail(), accountRequestDTO.getBill());
    }

    @GetMapping("/accounts/{id}")
    public AccountResponseDTO getAccount(@PathVariable Long id) {
        return new AccountResponseDTO(accountService.getAccountById(id));
    }

    @GetMapping("/accounts")
    public List<AccountResponseDTO> getAllAccounts() {
        return accountService.getAllAccounts().stream().map(AccountResponseDTO::new).collect(Collectors.toList());
    }

    @DeleteMapping("/accounts/{id}")
    public AccountResponseDTO deleteAccount(@PathVariable Long id) {
        return new AccountResponseDTO(accountService.deleteAccountById(id));
    }

}

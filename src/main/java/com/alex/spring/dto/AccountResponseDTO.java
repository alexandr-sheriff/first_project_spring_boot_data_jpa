package com.alex.spring.dto;

import com.alex.spring.entity.Account;

public class AccountResponseDTO {

    private Long accountId;

    private String name;

    private String email;

    private Integer bill;

    public AccountResponseDTO(Long accountId, String name, String email, Integer bill) {
        this.accountId = accountId;
        this.name = name;
        this.email = email;
        this.bill = bill;
    }

    public AccountResponseDTO(Account account) {
        this.accountId = account.getId();
        this.name = account.getName();
        this.email = account.getEmail();
        this.bill = account.getBill();
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getBill() {
        return bill;
    }

    public void setBill(Integer bill) {
        this.bill = bill;
    }
}

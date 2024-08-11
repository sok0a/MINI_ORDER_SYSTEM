package com.jasp.mini_order_system.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
@AllArgsConstructor
public class Account extends Common {

    // 계좌 번호
    @Getter
    private String accountNumber;
    // 계좌 잔액
    @Getter
    private int balance;
    // 출금 메서드
    public void withdraw(int amount) {
        balance -= amount;
    }
    // 입금 메서드
    public void deposit(int amount) {
        balance += amount;
    }
    /*public Account(String accountNumber, int balance) {
        super();
        this.accountNumber = accountNumber;
        this.balance = balance;
    }*/
}
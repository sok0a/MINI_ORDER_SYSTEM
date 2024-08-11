package com.jasp.mini_order_system.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
@AllArgsConstructor
public class Member extends Common {

    // 회원 이메일
    @Getter
    private String email;
    // 회원 비밀번호
    @Getter
    private String password;
    // 회원 닉네임
    @Getter
    private String nickname;
    // 회원 계좌
    @Getter
    private Account account;

    /*public Member(String email, String password, String nickname, Account account) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.account = account;
    }*/
}
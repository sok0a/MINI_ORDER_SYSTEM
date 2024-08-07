package com.jasp.mini_order_system.entity;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public abstract class Common {

    // 정적 변수로 고유 식별자를 위한 시퀀스 초기화
    private static int sequence = 0;

    // 고유 식별자 필드
    @EqualsAndHashCode.Include
    @Getter(value = AccessLevel.PUBLIC)
    private Integer id;

    // 생성자
    public Common() {
        // 고유 식별자 증가 및 할당
        this.id = ++sequence;
    }
}
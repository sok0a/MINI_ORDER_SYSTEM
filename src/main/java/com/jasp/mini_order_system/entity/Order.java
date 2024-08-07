package com.jasp.mini_order_system.entity;

import java.util.List;

public class Order extends Common {

    // 주문 회원
    // 주문한 상품 목록
    // 주문 코드
    // 주문 날짜
    // 총 상품 수량
    // 총 상품 금액

    // 생성자
    public Order(Member member, List<Item> orderedItemList) {
        // 주문 생성 로직
    }

    // 상품 추가 메서드
    // 상품 제거 메서드

    // 주문 업데이트 메서드
    private boolean updateOrder(Item item, int price, boolean isAdd) {
        if (isAdd) {
            // 상품 추가 로직
            // 주문 목록에 item 추가
            // totalItemAmount에 price 추가
            // totalItemCount 증가
        } else {
            // 상품 제거 로직
            // 주문 목록에서 item 제거
            // totalItemAmount에서 price 감소
            // totalItemCount 감소
        }
        return true;
    }

}
package com.jasp.mini_order_system.entity;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class Order extends Common {

    // 주문 회원
    private Member member;
    // 주문한 상품 목록
    private List<Item> orderedItemList;
    // 주문 코드
    private String orderCode;
    // 주문 날짜
    private LocalDateTime orderDate;
    // 총 상품 수량
    private int totalItemCount;
    // 총 상품 금액
    private int totalItemAmount;

    // 생성자
    public Order(Member member, List<Item> orderedItemList) {
        // 주문 생성 로직
        super();
        this.member = member;
        this.orderedItemList = new ArrayList<>(orderedItemList);
        this.orderCode = UUID.randomUUID().toString();
        this.orderDate = LocalDateTime.now();
        this.totalItemCount = orderedItemList.size();
        this.totalItemAmount = 0;
    }

    // 상품 추가 메서드
    public void addItem(List<Item> orderedItemList) {
        for (Item item : orderedItemList) {
//            orderedItemList.add(item);
            updateOrder(item, item.getItemPrice(), true);
        }
    }
    // 상품 제거 메서드
    public void removeItem(Item item){
//        orderedItemList.remove(item);
        updateOrder(item, item.getItemPrice(), false);
    }
    // 주문 업데이트 메서드
    private boolean updateOrder(Item item, int price, boolean isAdd) {
        if (isAdd) {
            // 상품 추가 로직
            // 주문 목록에 item 추가
            orderedItemList.add(item);
            // totalItemAmount에 price 추가
            totalItemAmount+=price;
            // totalItemCount 증가
            totalItemCount++;
        } else {
            // 상품 제거 로직
            // 주문 목록에서 item 제거
            orderedItemList.remove(item);
            // totalItemAmount에서 price 감소
            totalItemAmount-=price;
            // totalItemCount 감소
            totalItemCount--;
        }
        return true;
    }

}
package com.jasp.mini_order_system.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
@AllArgsConstructor
public class Item extends Common {

    // 상품 이름
    @Getter
    private String itemName;
    // 상품 가격
    @Getter
    private int itemPrice;
    // 상품 카테고리
    @Getter
    private Category category;
    /*public Item(String itemName, int itemPrice, Category category) {
        super();
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.category = category;

    }*/
}
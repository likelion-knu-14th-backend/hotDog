package com.example.session.dto;

import com.example.session.entity.Shop;
import lombok.Getter;

@Getter
public class ShopResponseDto {
    private String name;
    private String productNumber;
    private String price;

    private String prod;

    public ShopResponseDto(Shop shop) {
        this.name = shop.getName();
        this.productNumber = shop.getProductNumber();
        this.price = shop.getPrice();
        if (shop.getProduct() != null) {
            this.prod = shop.getProduct().getProd();
        } else {
            this.prod = "등록된 상품 없음"; // 또는 null
        }
    }
}

package com.example.session.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter @NoArgsConstructor
public class ShopCreateRequestDto {
    private String name;
    private String productNumber;
    private String price;
    private String prod;
}

package com.example.session.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter @NoArgsConstructor
public class ShopCreateRequestDto {

    @NotBlank(message = "이름은 필수입니다.")
    private String name;

    @NotBlank(message = "상품번호는 필수입니다.")
    private String productNumber;

    @NotBlank(message = "가격은 필수입니다.")
    private String price;

    private String prod;
}

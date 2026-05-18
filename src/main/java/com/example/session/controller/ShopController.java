package com.example.session.controller;

import com.example.session.dto.ShopCreateRequestDto;
import com.example.session.dto.ShopResponseDto;
import com.example.session.service.ShopService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shops")
@RequiredArgsConstructor
public class ShopController {

    private final ShopService shopService;

    // 상점 등록
    @PostMapping
    public ShopResponseDto createShop(@Valid @RequestBody ShopCreateRequestDto request) {
        return shopService.createShop(request);
    }

    // 전체 상점 조회
    @GetMapping
    public List<ShopResponseDto> getShops() {
        return shopService.getShops();
    }

    // 상품 번호 기준 단건 조회
    @GetMapping("/{productNumber}")
    public ShopResponseDto getShop(@PathVariable String productNumber) {
        return shopService.getShop(productNumber);
    }

    // 상품 번호 기준 수정
    @PutMapping("/{productNumber}")
    public ShopResponseDto updateShop(
            @PathVariable String productNumber,
            @Valid @RequestBody ShopCreateRequestDto request
    ) {
        return shopService.updateShop(productNumber, request);
    }

    // 상품 번호 기준 삭제
    @DeleteMapping("/{productNumber}")
    public void deleteShop(@PathVariable String productNumber) {
        shopService.deleteShop(productNumber);
    }

}
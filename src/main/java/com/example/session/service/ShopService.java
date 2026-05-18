package com.example.session.service;

import com.example.session.dto.ShopCreateRequestDto;
import com.example.session.dto.ShopResponseDto;
import com.example.session.entity.Product;
import com.example.session.entity.Shop;
import com.example.session.exception.ShopNotFoundException;
import com.example.session.repository.ShopRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShopService {
    private final ShopRepository shopRepository;

    @Transactional
    public ShopResponseDto createShop(ShopCreateRequestDto request) {
        Shop shop = new Shop(
                request.getName(),
                request.getProductNumber(),
                request.getPrice()
        );
        Product product = new Product();
        product.setProd(request.getProd());
        product.setShop(shop);
        shop.setProduct(product);
        Shop savedShop = shopRepository.save(shop);
        return new ShopResponseDto(savedShop);
    }

    public List<ShopResponseDto> getShops() {
        return shopRepository.findAll()
                .stream()
                .map(ShopResponseDto::new)
                .toList();
    }

    public ShopResponseDto getShop(String productNumber) {
        Shop shop = shopRepository.findByProductNumber(productNumber)
                .orElseThrow(ShopNotFoundException::new);
        return new ShopResponseDto(shop);
    }

    @Transactional
    public ShopResponseDto updateShop(String productNumber, ShopCreateRequestDto request) {
        Shop shop = shopRepository.findByProductNumber(productNumber)
                .orElseThrow(ShopNotFoundException::new);

        shop.update(
                request.getName(),
                request.getProductNumber(),
                request.getPrice()
        );

        Product product = new Product();
        product.setProd(request.getProd());
        product.setShop(shop);
        shop.setProduct(product);

        Shop updatedShop = shopRepository.save(shop);
        return new ShopResponseDto(updatedShop);
    }

    public void deleteShop(String productNumber) {
        Shop shop = shopRepository.findByProductNumber(productNumber)
                .orElseThrow(ShopNotFoundException::new);

        shopRepository.delete(shop);
    }
}
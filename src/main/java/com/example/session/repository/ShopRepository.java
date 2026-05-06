package com.example.session.repository;

import com.example.session.entity.Shop;
import com.example.session.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShopRepository extends JpaRepository<Shop, Long> {
    Optional<Shop> findByProductNumber(String productNumber);
}

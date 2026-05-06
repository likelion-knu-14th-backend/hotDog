package com.example.session.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Getter @Setter @NoArgsConstructor
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true, nullable = false)
    private String productNumber;

    private String price;

    @OneToOne(mappedBy = "shop", cascade = CascadeType.ALL)
    private Product product;

    public Shop(String name, String productNumber, String price){
        this.name = name;
        this.productNumber = productNumber;
        this.price = price;
    }

    public void update(String name, String productNumber, String price) {
        this.name = name;
        this.productNumber = productNumber;
        this.price = price;
    }
}

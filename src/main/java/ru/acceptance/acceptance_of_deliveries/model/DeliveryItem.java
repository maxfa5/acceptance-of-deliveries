package ru.acceptance.acceptance_of_deliveries.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class DeliveryItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "delivery_id", nullable = false)
    private Delivery delivery;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(nullable = false)
    private BigDecimal quantity; // Количество товара


    // Геттеры и сеттеры
}
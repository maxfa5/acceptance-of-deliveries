// package ru.acceptance.model;

// import jakarta.persistence.*;
// import java.math.BigDecimal;

// @Entity
// public class Product {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(nullable = false)
//     private String name;

//     @Column(nullable = false)
//     private String type; 

//     private String description;

//     @Column(nullable = false)
//     private BigDecimal price;

//     // Геттеры и сеттеры
// }

package ru.acceptance.acceptance_of_deliveries.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import lombok.*;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private BigDecimal price;
    private String type;
    public Product() {
    }
    // Геттеры и сеттеры
}
package ru.acceptance.acceptance_of_deliveries.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.acceptance.acceptance_of_deliveries.model.Product;

import java.util.List;

@Entity
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    // Геттеры и сеттеры
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
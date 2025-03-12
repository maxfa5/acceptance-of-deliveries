package ru.acceptance.acceptance_of_deliveries.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.acceptance.acceptance_of_deliveries.model.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@Entity
public class SupplierPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "supplier_id", nullable = false)
    private Supplier supplier;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private LocalDate validFrom;

}
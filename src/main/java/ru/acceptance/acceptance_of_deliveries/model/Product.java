
package ru.acceptance.acceptance_of_deliveries.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor
@Data
public class Product {
    private BigDecimal weight;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type;

}
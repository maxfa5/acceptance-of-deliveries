package ru.acceptance.acceptance_of_deliveries.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.acceptance.acceptance_of_deliveries.model.Product;

import java.math.BigDecimal;
import java.util.Optional;

public interface ProductWeightRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p WHERE p.id = :productId AND p.weight = :weight")
    Optional<Product> findProductByIdAndWeight(@Param("productId") Long productId, @Param("weight") BigDecimal weight);
}
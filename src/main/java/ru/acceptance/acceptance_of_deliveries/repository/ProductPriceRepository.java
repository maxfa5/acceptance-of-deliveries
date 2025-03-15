package ru.acceptance.acceptance_of_deliveries.repository;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.acceptance.acceptance_of_deliveries.model.ProductPrice;

import java.time.LocalDateTime;
import java.util.Optional;

public interface ProductPriceRepository extends JpaRepository<ProductPrice, Long> {
    @Transactional(isolation = Isolation.READ_COMMITTED)
    @Query("SELECT pp FROM ProductPrice pp WHERE pp.product.id = :productId AND pp.validFrom <= :date ORDER BY pp.validFrom DESC")
    Optional<ProductPrice> findLatestPrice(@Param("productId") Long productId, @Param("date") LocalDateTime date);
}
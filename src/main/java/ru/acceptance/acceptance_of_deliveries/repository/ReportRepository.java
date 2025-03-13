package ru.acceptance.acceptance_of_deliveries.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.acceptance.acceptance_of_deliveries.model.Delivery;

import java.time.LocalDateTime;
import java.util.List;

public interface ReportRepository extends JpaRepository<Delivery, Long> {
    @Query("SELECT d FROM Delivery d WHERE d.deliveryDate >= :startDate AND d.deliveryDate <= :endDate")
    List<Delivery> findBetweenDates(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);
}

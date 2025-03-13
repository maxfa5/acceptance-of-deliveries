package ru.acceptance.acceptance_of_deliveries.repository;

import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.acceptance.acceptance_of_deliveries.DTO.SupplierProductReport;
import ru.acceptance.acceptance_of_deliveries.model.Delivery;

import java.time.LocalDateTime;
import java.util.List;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {

    @Query("SELECT NEW ru.acceptance.acceptance_of_deliveries.DTO.SupplierProductReport(" +
    "s.name, p.name, SUM(i.weight), SUM(i.priceOfDeliveryItem)) " +
    "FROM Delivery d " +
    "JOIN d.supplier s " +
    "JOIN d.items i " +
    "JOIN i.product p " +
    "WHERE d.deliveryDate BETWEEN :startDate AND :endDate " +
    "GROUP BY s.name, p.name")
    List<SupplierProductReport> getSupplierProductReport(
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate
    );
}
package ru.acceptance.acceptance_of_deliveries.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.acceptance.acceptance_of_deliveries.model.Delivery;
import ru.acceptance.acceptance_of_deliveries.model.Product;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
}
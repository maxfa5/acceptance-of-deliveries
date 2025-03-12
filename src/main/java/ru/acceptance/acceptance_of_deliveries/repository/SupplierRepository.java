package ru.acceptance.acceptance_of_deliveries.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.acceptance.acceptance_of_deliveries.model.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
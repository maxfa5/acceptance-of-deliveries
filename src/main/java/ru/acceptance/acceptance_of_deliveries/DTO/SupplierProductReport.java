package ru.acceptance.acceptance_of_deliveries.DTO;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class SupplierProductReport {
    private String supplierName;
    private String productName;
    private BigDecimal totalWeight;
    private BigDecimal totalCost;

    public SupplierProductReport(String supplierName, String productName, BigDecimal totalWeight, BigDecimal totalCost) {
        this.supplierName = supplierName;
        this.productName = productName;
        this.totalWeight = totalWeight;
        this.totalCost = totalCost;
    }
}

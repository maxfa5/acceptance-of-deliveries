package ru.acceptance.acceptance_of_deliveries.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.acceptance.acceptance_of_deliveries.DTO.SupplierProductReport;
import ru.acceptance.acceptance_of_deliveries.service.DeliveryService;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    @Autowired
    private DeliveryService deliveryService;
    @GetMapping
    public List<SupplierProductReport> getSupplierProductReport(
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDateTime startDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDateTime endDate
    ) {
        return deliveryService.getSupplierProductReport(startDate, endDate);
    }
}
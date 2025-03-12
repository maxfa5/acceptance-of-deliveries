package ru.acceptance.acceptance_of_deliveries.controller;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ru.acceptance.acceptance_of_deliveries.DTO.DeliveryRequest;
import ru.acceptance.acceptance_of_deliveries.model.Delivery;
import ru.acceptance.acceptance_of_deliveries.model.Product;
import ru.acceptance.acceptance_of_deliveries.model.Supplier;
import ru.acceptance.acceptance_of_deliveries.repository.DeliveryRepository;
import ru.acceptance.acceptance_of_deliveries.repository.ProductRepository;
import ru.acceptance.acceptance_of_deliveries.repository.SupplierRepository;

import ru.acceptance.acceptance_of_deliveries.service.DeliveryService;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/deliveries") // More specific and informative request mapping
@Slf4j // Automatically creates a logger field called 'log'
@NoArgsConstructor
public class DeliveryController {

   @Autowired
    private DeliveryService deliveryService;

    @Autowired
    private SupplierRepository supplierRepository;
    @GetMapping
    public List<Delivery> getAllDeliveries() {
        return deliveryService.getAllDeliveries();
    }

    @PostMapping
    public Delivery createDelivery(@RequestBody DeliveryRequest request) {
        return deliveryService.createDelivery(request.getSupplierId(), request.getItems());
    }

}
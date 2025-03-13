package ru.acceptance.acceptance_of_deliveries.controller;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import ru.acceptance.acceptance_of_deliveries.DTO.DeliveryRequest;
import ru.acceptance.acceptance_of_deliveries.model.Delivery;
import ru.acceptance.acceptance_of_deliveries.repository.ProductRepository;
import ru.acceptance.acceptance_of_deliveries.repository.SupplierRepository;

import ru.acceptance.acceptance_of_deliveries.service.DeliveryService;


@Controller
@Slf4j
@NoArgsConstructor
public class DeliveryController {

   @Autowired
    private DeliveryService deliveryService;

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/delivery/new")
    public String showForm(Model model) {
        model.addAttribute("delivery", new DeliveryRequest());
        model.addAttribute("suppliers", supplierRepository.findAll());
        model.addAttribute("products", productRepository.findAll());
        return "delivery-form";
    }

    @PostMapping("/delivery/save")
    public String saveDelivery(@ModelAttribute DeliveryRequest delivery, Model model) {
        try {
            deliveryService.createDelivery(delivery.getSupplierId(), delivery.getItems());
            model.addAttribute("message", "Поставка успешно сохранена!");
        } catch (Exception e) {
            log.error("Ошибка при сохранении поставки", e);
            model.addAttribute("errorMessage", "Ошибка при сохранении поставки: " + e.getMessage());
        }

        // Возвращаем тот же шаблон с обновлёнными данными
        model.addAttribute("delivery", new DeliveryRequest()); // Очищаем форму
        model.addAttribute("suppliers", supplierRepository.findAll());
        model.addAttribute("products", productRepository.findAll());
        return "delivery-form";
    }
    @PostMapping("/api/deliveries") 
    public Delivery createDelivery(@RequestBody DeliveryRequest request) {
        return deliveryService.createDelivery(request.getSupplierId(), request.getItems());
    }

}
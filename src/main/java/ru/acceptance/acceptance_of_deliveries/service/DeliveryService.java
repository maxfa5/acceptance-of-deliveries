package ru.acceptance.acceptance_of_deliveries.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.acceptance.acceptance_of_deliveries.model.Delivery;
import ru.acceptance.acceptance_of_deliveries.model.Supplier;
import ru.acceptance.acceptance_of_deliveries.repository.*;

import java.time.LocalDate;
import java.util.HashMap;

@Slf4j
@Service
public class DeliveryService {
    @Autowired
    private DeliveryRepository deliveryRepository;

    @Autowired
    private DeliveryItemRepository deliveryItemRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    // public Delivery createDelivery(DeliveryRequest request) {
    //     // Логика создания поставки
    //     return new Delivery();
    // }

    public HashMap<Object, Object> getAllDeliveries() {
        log.info("Creating sample deliveries...");

        // Логика получения всех поставок
        HashMap<Object, Object> data = new HashMap<>();
        data.put("deliveries", deliveryRepository.findAll());
        data.put("deliveryItems", deliveryItemRepository.findAll());
        data.put("products", productRepository.findAll());
        data.put("suppliers", supplierRepository.findAll());
        return data;
        // return List.of();
    }

    public void createSampleDeliveries() {
        // Получаем поставщика (предположим, что он уже существует)
        Supplier supplier = supplierRepository.findById(1L)
            .orElseThrow(() -> new RuntimeException("Supplier not found"));

        // Создаем первую поставку
        Delivery delivery1 = new Delivery();
        delivery1.setSupplier(supplier);
        delivery1.setDeliveryDate(LocalDate.now());
        deliveryRepository.save(delivery1);

        // Создаем вторую поставку
        Delivery delivery2 = new Delivery();
        delivery2.setSupplier(supplier);
        delivery2.setDeliveryDate(LocalDate.now().plusDays(1));
        deliveryRepository.save(delivery2);
    }
}
package ru.acceptance.acceptance_of_deliveries.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.acceptance.acceptance_of_deliveries.DTO.DeliveryItemRequest;
import ru.acceptance.acceptance_of_deliveries.DTO.DeliveryRequest;
import ru.acceptance.acceptance_of_deliveries.model.Delivery;
import ru.acceptance.acceptance_of_deliveries.model.DeliveryItem;
import ru.acceptance.acceptance_of_deliveries.model.Product;
import ru.acceptance.acceptance_of_deliveries.model.Supplier;
import ru.acceptance.acceptance_of_deliveries.repository.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

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

    public List<Delivery> getAllDeliveries() {
        return deliveryRepository.findAll();
    }

    public Delivery createDelivery(Long supplierId, List<DeliveryItemRequest> items) {
        // Проверка существования поставщика
        Supplier supplier = supplierRepository.findById(supplierId)
                .orElseThrow(() -> new RuntimeException("Supplier not found with id: " + supplierId));

        // Создание поставки
        Delivery delivery = new Delivery();
        delivery.setSupplier(supplier);
        delivery.setDeliveryDate(LocalDate.now());

        // Добавление позиций
        for (DeliveryItemRequest itemRequest : items) {
            // Проверка существования продукта
            Product product = productRepository.findById(itemRequest.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found with id: " + itemRequest.getProductId()));

            // Создание позиции
            DeliveryItem item = new DeliveryItem();
            item.setProduct(product);
            item.setQuantity(itemRequest.getQuantity());
            item.setDelivery(delivery); // Установите связь с Delivery
            item.setPricePerUnit(1);//TODO!!
            // Добавление позиции в список
            delivery.getItems().add(item);
        }

        // Сохранение поставки (позиции сохранятся каскадно)
        return deliveryRepository.save(delivery);
    }
}
//    public void createSampleDeliveries() {
//        // Получаем поставщика (предположим, что он уже существует)
//        Supplier supplier = supplierRepository.findById(1L)
//            .orElseThrow(() -> new RuntimeException("Supplier not found"));
//
//        // Создаем первую поставку
//        Delivery delivery1 = new Delivery();
//        delivery1.setSupplier(supplier);
//        delivery1.setDeliveryDate(LocalDate.now());
//        deliveryRepository.save(delivery1);
//
//        // Создаем вторую поставку
//        Delivery delivery2 = new Delivery();
//        delivery2.setSupplier(supplier);
//        delivery2.setDeliveryDate(LocalDate.now().plusDays(1));
//        deliveryRepository.save(delivery2);
//    }
//}
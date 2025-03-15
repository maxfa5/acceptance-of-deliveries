package ru.acceptance.acceptance_of_deliveries.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.acceptance.acceptance_of_deliveries.DTO.DeliveryItemRequest;
import ru.acceptance.acceptance_of_deliveries.DTO.SupplierProductReport;
import ru.acceptance.acceptance_of_deliveries.model.*;
import ru.acceptance.acceptance_of_deliveries.repository.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class DeliveryService {
    @Autowired
    private DeliveryRepository deliveryRepository;


    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SupplierRepository supplierRepository;


    @Autowired
    private ProductPriceRepository productPriceRepository;

    public Delivery createDelivery(Long supplierId, List<DeliveryItemRequest> items) {
        Supplier supplier = supplierRepository.findById(supplierId)
                .orElseThrow(() -> new RuntimeException("Supplier not found with id: " + supplierId));

        Delivery delivery = new Delivery();
        delivery.setSupplier(supplier);
        delivery.setDeliveryDate(LocalDate.now());

        for (DeliveryItemRequest itemRequest : items) {
            Product product = productRepository.findById(itemRequest.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found with id: " + itemRequest.getProductId()));
            DeliveryItem item = new DeliveryItem();
            item.setQuantity(itemRequest.getQuantity());
            item.setProduct(product);
            item.setWeight(product.getWeight().multiply(item.getQuantity()));
            ProductPrice productPrice = productPriceRepository.findLatestPrice(
                            itemRequest.getProductId(), LocalDateTime.now())
                    .orElseThrow(() -> new RuntimeException("Price not found for product ID: " + itemRequest.getProductId()));            // Добавление позиции в список
            item.setPriceOfDeliveryItem(productPrice.getPrise().multiply(item.getQuantity()));

            item.setDelivery(delivery);
            delivery.getItems().add(item);
            delivery.setWeight(delivery.getWeight().add(item.getWeight()));
            delivery.setPrice(delivery.getPrice().add(item.getPriceOfDeliveryItem()));

        }

        return deliveryRepository.save(delivery);
    }

    public List<SupplierProductReport> getSupplierProductReport(LocalDateTime startDate, LocalDateTime endDate) {
        return deliveryRepository.getSupplierProductReport(startDate, endDate);
    }

}
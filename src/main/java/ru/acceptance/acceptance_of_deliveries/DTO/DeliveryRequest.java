package ru.acceptance.acceptance_of_deliveries.DTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DeliveryRequest {
    private Long supplierId;
    private LocalDate deliveryDate;
    private List<DeliveryItemRequest> items = new ArrayList<>();
    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public List<DeliveryItemRequest> getItems() {
    return items;
    }
}
package ru.acceptance.acceptance_of_deliveries.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class DeliveryRequest {
    private Long supplierId;
    private LocalDate deliveryDate;
    private List<DeliveryItemRequest> items = new ArrayList<>();
    public Long getSupplierId() {
        return supplierId;
    }


    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }


    public List<DeliveryItemRequest> getItems() {
    return items;
    }
}
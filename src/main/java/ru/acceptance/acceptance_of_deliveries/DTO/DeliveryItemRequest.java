package ru.acceptance.acceptance_of_deliveries.DTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DeliveryItemRequest {
    private Long productId;
    private int quantity;
}
package ru.acceptance.acceptance_of_deliveries.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.acceptance.acceptance_of_deliveries.model.Supplier;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@NoArgsConstructor
@Entity
@Table(name = "deliveries") // Optional: Specify table name
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "supplier_id", nullable = false)
    private Supplier supplier;

    @Column(nullable = false)
    private LocalDate deliveryDate;

    @OneToMany(mappedBy = "delivery", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DeliveryItem> items = new ArrayList<>();

    public Delivery(Supplier supplier, LocalDate deliveryDate) {
        this.supplier = supplier;
        this.deliveryDate = deliveryDate;
    }

    public Long getId() {
        return id;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public List<DeliveryItem> getItems() {
        return items;
    }

    public void setItems(List<DeliveryItem> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Delivery delivery = (Delivery) o;
        return Objects.equals(id, delivery.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "id=" + id +
                ", supplier=" + supplier +
                ", deliveryDate=" + deliveryDate +
                ", items=" + items +
                '}';
    }
}
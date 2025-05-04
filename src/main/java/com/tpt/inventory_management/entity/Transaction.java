package com.tpt.inventory_management.entity;

import com.tpt.inventory_management.enums.TransactionStatus;
import com.tpt.inventory_management.enums.TransactionType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "transactions")
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @Positive(message = "Total product can not be negative")
    private Integer totalProduct;

    @Positive(message = "Total price can not be negative")
    private Integer totalPrice;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    @Enumerated(EnumType.STRING)
    private TransactionStatus transactionStatus;

    private String note;

    private String description;

    private final LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @Override
    public String toString() {
        return "Transaction{" +
                "updatedAt=" + updatedAt +
                ", createdAt=" + createdAt +
                ", description='" + note + '\'' +
                ", transactionStatus=" + transactionStatus +
                ", transactionType=" + transactionType +
                ", totalPrice=" + totalPrice +
                ", totalProduct=" + totalProduct +
                ", id=" + id +
                '}';
    }
}

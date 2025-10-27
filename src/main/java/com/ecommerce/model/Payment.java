package com.ecommerce.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

    private String paymentMethod;  // e.g. "RAZORPAY", "STRIPE"
    private String paymentStatus;  // e.g. "SUCCESS", "FAILED", "PENDING"
    private String transactionId;

    private LocalDateTime paymentDate = LocalDateTime.now();
}

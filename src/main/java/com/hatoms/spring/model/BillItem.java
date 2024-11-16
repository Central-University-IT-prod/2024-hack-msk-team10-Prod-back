package com.hatoms.spring.model;

import lombok.Builder;
import lombok.Data;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Builder
@Table(name = "bill_items")
public class BillItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "bill_id", nullable = false)
    private Bill bill;

    @Column(name = "item_description", nullable = false, length = 255)
    private String itemDescription;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal amount;
}

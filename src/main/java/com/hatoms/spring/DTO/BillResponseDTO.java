package com.hatoms.spring.DTO;

import com.hatoms.spring.model.BillItem;
import com.hatoms.spring.model.User;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class BillResponseDTO {
    private Long id;
    private BigDecimal totalAmount;
    private LocalDateTime createdAt;
    private String title;
}

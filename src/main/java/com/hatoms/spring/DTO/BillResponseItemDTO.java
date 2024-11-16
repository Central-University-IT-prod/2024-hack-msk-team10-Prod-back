package com.hatoms.spring.DTO;

import com.hatoms.spring.model.BillItem;
import com.hatoms.spring.model.User;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class BillResponseItemDTO {
    private Long id;
    private Long billId;
    private BigDecimal amount;
    private String itemDescription;
}
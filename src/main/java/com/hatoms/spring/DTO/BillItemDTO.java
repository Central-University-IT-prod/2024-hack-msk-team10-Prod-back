package com.hatoms.spring.DTO;

import java.math.BigDecimal;
import java.util.List;

public record BillItemDTO(
        Long userId,
        Long billId,
        String itemDescription,
        BigDecimal amount) {

}
package com.hatoms.spring.DTO;

import java.math.BigDecimal;
import java.util.List;

public record BillCreationDTO(
        Long userId,
        String title,
        BigDecimal amount,
        List<String> emails

) {

}

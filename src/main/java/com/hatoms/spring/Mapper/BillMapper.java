package com.hatoms.spring.Mapper;

import com.hatoms.spring.DTO.BillResponseDTO;
import com.hatoms.spring.DTO.BillResponseItemDTO;
import com.hatoms.spring.model.Bill;
import com.hatoms.spring.model.BillItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BillMapper {
    BillResponseDTO toResponse(Bill bill);
    @Mapping(target = "billId", source = "bill.id")
    BillResponseItemDTO toResponse(BillItem billItem);
}

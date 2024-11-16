package com.hatoms.spring.service;

import com.hatoms.spring.DTO.BillCreationDTO;
import com.hatoms.spring.DTO.BillItemDTO;
import com.hatoms.spring.model.Bill;
import com.hatoms.spring.model.BillItem;
import com.hatoms.spring.repository.BillItemRepository;
import com.hatoms.spring.repository.BillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BillService {
    private final UserService userService;
    private final BillRepository billRepository;
    private final BillItemRepository billItemRepository;

    public Bill create(BillCreationDTO billCreationDTO) {
        var user = userService.getUserById(billCreationDTO.userId());
        billCreationDTO.emails().add(user.getEmail());
        var members = userService.getAllByEmails(billCreationDTO.emails());
        var bill = Bill.builder()
                .owner(user)
                .title(billCreationDTO.title())
                .totalAmount(billCreationDTO.amount())
                .group(members)
                .build();
        return billRepository.save(bill);
    }

    public BillItem create(BillItemDTO billItemDTO) {
        var user = userService.getUserById(billItemDTO.userId());
        var bill = getBillById(billItemDTO.billId());
        var billItem = BillItem.builder().bill(bill).itemDescription(billItemDTO.itemDescription()).amount(billItemDTO.amount()).build();
        return billItemRepository.save(billItem);
    }
    public Bill getBillById(Long id) {
        return billRepository.findById(id).orElseThrow(() -> new RuntimeException("Bill is not found"));
    }

    public List<Bill> getAllBillsByUserId(Long userId) {
        var user = userService.getUserById(userId);
        return billRepository.findAllByUser2(user);
    }
}
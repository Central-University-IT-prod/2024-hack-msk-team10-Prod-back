package com.hatoms.spring.controller;

import com.hatoms.spring.DTO.BillCreationDTO;
import com.hatoms.spring.DTO.BillItemDTO;
import com.hatoms.spring.DTO.BillResponseDTO;
import com.hatoms.spring.DTO.BillResponseItemDTO;
import com.hatoms.spring.Mapper.BillMapper;
import com.hatoms.spring.model.Bill;
import com.hatoms.spring.model.BillItem;
import com.hatoms.spring.model.Group;
import com.hatoms.spring.service.BillService;
import com.hatoms.spring.service.GroupService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/bills")
@Tag(name = "Работа с счетами")
public class BillController {

    private final BillService billService;
    private final BillMapper billMapper;

    @Operation(summary = "Создание нового платежа")
    @PostMapping
    public BillResponseDTO responseDTO (@RequestBody BillCreationDTO billCreationDTO){
        return billMapper.toResponse(billService.create(billCreationDTO));
    }

    @Operation(summary = "Добавление нового платежа")
    @PostMapping("/item")
    public BillResponseItemDTO responseDTO (@RequestBody BillItemDTO billItemDTO){
        return billMapper.toResponse(billService.create(billItemDTO));
    }
    @Operation(summary = "Получение счета по ID")
    @GetMapping("/{id}")
    public BillResponseDTO getBillById(@PathVariable Long Billid) {
        Bill bill = billService.getBillById(Billid);
        return billMapper.toResponse(bill);
    }
    @Operation(summary = "Получение всех счетов пользователя по user_id")
    @GetMapping("/user/{user_id}")
    public List<BillResponseDTO> getAllBillsByUserId(@PathVariable Long user_id) {
        List<Bill> bills = billService.getAllBillsByUserId(user_id);
        return bills.stream()
                .map(billMapper::toResponse)
                .collect(Collectors.toList());
    }






//    // Создание группы
//    @PostMapping
//    public Group createGroup(@RequestBody Group emails) {
//        return groupService.createGroup(emails);
//    }
//
//    // Добавление пользователя в группу
//    @PostMapping("/{groupId}/addUser/{userId}")
//    public Group addUserToGroup(@PathVariable Long groupId,
//                                @PathVariable Long userId) {
//        return groupService.addUserToGroup(groupId, userId);
//    }
//
//    // Получение всех групп
//    @GetMapping
//    public List<Group> getAllGroups() {
//        return groupService.getAllGroups();
//    }
}

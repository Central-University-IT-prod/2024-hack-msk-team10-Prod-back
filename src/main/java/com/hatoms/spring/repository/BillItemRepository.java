package com.hatoms.spring.repository;

import com.hatoms.spring.model.Bill;
import com.hatoms.spring.model.BillItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillItemRepository extends JpaRepository<BillItem, Long> {
}

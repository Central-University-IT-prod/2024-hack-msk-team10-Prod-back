package com.hatoms.spring.repository;

import com.hatoms.spring.model.Bill;
import com.hatoms.spring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BillRepository extends JpaRepository<Bill, Long> {
    List<Bill> findByOwner(User user);
    @Query("SELECT b FROM Bill b WHERE b.group IN (SELECT g FROM Group g JOIN g.users u WHERE u = :user)")
    List<Bill> findAllByUser2(User user);
}

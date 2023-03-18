package com.bees.OrderFood.service;

import com.bees.OrderFood.model.Bill;
import com.bees.OrderFood.model.DetailBill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BillService {
    Page<Bill> findAllBill(Pageable pageable);
    List<Bill> listAll();
    Bill create(Bill bill, DetailBill detailBill, String code);
    Bill findById(Long id);
    void delete(Long id);
}

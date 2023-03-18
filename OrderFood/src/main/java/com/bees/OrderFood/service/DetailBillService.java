package com.bees.OrderFood.service;

import com.bees.OrderFood.model.DetailBill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface DetailBillService {
    Page<DetailBill> findAllDetailBill(Pageable pageable);
    List<DetailBill> listAllDetailBill();
    DetailBill findById(Long id);
    List<DetailBill> findByBillId(Long id);
    void delete(Long id);
}

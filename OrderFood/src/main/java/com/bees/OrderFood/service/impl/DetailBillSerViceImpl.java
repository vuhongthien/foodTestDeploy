package com.bees.OrderFood.service.impl;

import com.bees.OrderFood.model.DetailBill;
import com.bees.OrderFood.repository.DetailBillRepository;
import com.bees.OrderFood.service.DetailBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailBillSerViceImpl implements DetailBillService {
    @Autowired
    private DetailBillRepository detailBillRepository;
    @Override
    public Page<DetailBill> findAllDetailBill(Pageable pageable) {
        return detailBillRepository.findAll(pageable);
    }

    @Override
    public List<DetailBill> listAllDetailBill() {
        return detailBillRepository.findAll();
    }


    @Override
    public DetailBill findById(Long id) {
        return detailBillRepository.findById(id).get();
    }

    @Override
    public List<DetailBill> findByBillId(Long id) {
        return detailBillRepository.findByBillId(id);
    }

    @Override
    public void delete(Long id) {
        detailBillRepository.deleteById(id);
    }
}

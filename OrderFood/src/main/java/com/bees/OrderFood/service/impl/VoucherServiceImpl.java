package com.bees.OrderFood.service.impl;

import com.bees.OrderFood.model.Voucher;
import com.bees.OrderFood.repository.VoucherRepository;
import com.bees.OrderFood.service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class VoucherServiceImpl implements VoucherService {
    @Autowired
    private VoucherRepository voucherRepository;
    @Override
    public Page<Voucher> findAllImage(Pageable pageable) {
        return voucherRepository.findAll(pageable);
    }

    @Override
    public Voucher create(Voucher voucher) {
        return voucherRepository.save(voucher);
    }

    @Override
    public Voucher findById(Long id) {
        return voucherRepository.findById(id).get();
    }

    @Override
    public Voucher findByCodeVoucher(String code) {
        return voucherRepository.findByCodeVoucher(code);
    }

    @Override
    public void delete(Long id) {
        voucherRepository.deleteById(id);
    }
}

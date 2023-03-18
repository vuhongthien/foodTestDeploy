package com.bees.OrderFood.repository;

import com.bees.OrderFood.model.DetailBill;
import com.bees.OrderFood.model.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoucherRepository extends JpaRepository<Voucher,Long> {
    @Query(value = "SELECT * FROM tbl_voucher WHERE voucher_code =:code", nativeQuery = true)
    Voucher findByCodeVoucher(@Param("code") String code);
}

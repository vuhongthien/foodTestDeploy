package com.bees.OrderFood.repository;

import com.bees.OrderFood.model.DetailBill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetailBillRepository extends JpaRepository<DetailBill, Long> {
    @Query(value = "SELECT * " +
            "FROM tbl_detail_bill a " +
            "WHERE a.bill_id =:billid", nativeQuery = true)
    List<DetailBill> findByBillId(@Param("billid") Long billid);
}

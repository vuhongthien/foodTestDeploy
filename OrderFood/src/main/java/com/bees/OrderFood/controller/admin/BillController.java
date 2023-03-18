package com.bees.OrderFood.controller.admin;

import com.bees.OrderFood.model.Bill;
import com.bees.OrderFood.model.DetailBill;
import com.bees.OrderFood.service.impl.BillServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class BillController {
    @Autowired
    BillServiceImpl billService;
    @PostMapping("/add-bill")
    public Bill addbill(@RequestParam("user_id") Long userid,@RequestParam("voucher_code") String vouchercode){
        Bill bill = new Bill();
        bill.setUserId(userid);
        DetailBill detailBill = new DetailBill();
        return billService.create(bill, detailBill, vouchercode);
    }
    @GetMapping("/list-bill/{pageNumber}/{pageSize}")
    public Page<Bill> listall(@PathVariable(name = "pageNumber") Integer pageNumber,
                                    @PathVariable(name = "pageSize") Integer pageSize){
        return billService.findAllBill(PageRequest.of(pageNumber,pageSize));
    }
    @GetMapping("/list-bill")
    public List<Bill> listallbill(){
        return billService.listAll();
    }
}

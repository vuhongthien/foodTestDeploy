package com.bees.OrderFood.controller.admin;

import com.bees.OrderFood.model.Voucher;
import com.bees.OrderFood.service.impl.VoucherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api")
public class VoucherController {
    @Autowired
    VoucherServiceImpl voucherService;
    @GetMapping("/list-voucher/{pageNumber}/{pageSize}")
    public Page<Voucher> listall(@PathVariable(name = "pageNumber") Integer pageNumber,
                                 @PathVariable(name = "pageSize") Integer pageSize){
        return voucherService.findAllImage(PageRequest.of(pageNumber,pageSize));
    }
    @PostMapping("/add-voucher")
    public Voucher addvoucher(@RequestParam("voucher_code") String vouchercode,
                            @RequestParam("discount") float discount,
                              @RequestParam("quantity") Long quantity,
                              @RequestParam("dish_id") Long dishid,
                            @RequestParam("end_at") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endat){
        Voucher voucher = new Voucher();
        voucher.setVoucherCode(vouchercode);
        voucher.setDiscount(discount);
        voucher.setCreateAt(LocalDateTime.now());
        voucher.setEndAt(endat);
        voucher.setDishId(dishid);
        voucher.setQuantity(quantity);
        return voucherService.create(voucher);
    }
    @PutMapping("/edit-voucher")
    public Voucher editvoucher(@RequestParam("voucher_code") String vouchercode,
                             @RequestParam("discount") float discount,
                               @RequestParam("dish_id") Long dishid,
                             @RequestParam("end_at") LocalDateTime endat,
                              @RequestParam("id") Long id){
        Voucher voucher = voucherService.findById(id);
        voucher.setVoucherCode(vouchercode);
        voucher.setDiscount(discount);
        voucher.setCreateAt(LocalDateTime.now());
        voucher.setEndAt(endat);
        voucher.setDishId(dishid);
        return voucherService.create(voucher);
    }
    @DeleteMapping("/drop-voucher")
    public ResponseEntity dropvoucher(@RequestParam("id") Long id){
        voucherService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

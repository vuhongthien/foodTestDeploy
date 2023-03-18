package com.bees.OrderFood.model;

import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_voucher")
public class Voucher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "voucher_id")
    private Long VoucherId;
    @Column(name = "voucher_code")
    private String VoucherCode;
    @Column(name = "discount")
    private float discount;
    @Column(name = "create_at")
    private LocalDateTime CreateAt;
    @Column(name = "end_at")
    private LocalDateTime EndAt;
    @ManyToOne(optional=false)
    @JoinColumn(name = "dish_id", insertable=false, updatable=false)
    @ToString.Exclude
    private Dish Dish;
    @Column(name = "dish_id", nullable=false)
    private Long DishId;
    @Column(name = "quantity")
    private Long quantity;

    public Voucher(Long voucherId, String voucherCode, float discount, LocalDateTime createAt, LocalDateTime endAt, com.bees.OrderFood.model.Dish dish, Long dishId, Long quantity) {
        VoucherId = voucherId;
        VoucherCode = voucherCode;
        this.discount = discount;
        CreateAt = createAt;
        EndAt = endAt;
        Dish = dish;
        DishId = dishId;
        this.quantity = quantity;
    }

    public Voucher() {
    }

    public Long getVoucherId() {
        return VoucherId;
    }

    public void setVoucherId(Long voucherId) {
        VoucherId = voucherId;
    }

    public String getVoucherCode() {
        return VoucherCode;
    }

    public void setVoucherCode(String voucherCode) {
        VoucherCode = voucherCode;
    }

    public float getDiscount() {
        return discount;
    }
    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public LocalDateTime getCreateAt() {
        return CreateAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        CreateAt = createAt;
    }

    public LocalDateTime getEndAt() {
        return EndAt;
    }

    public void setEndAt(LocalDateTime endAt) {
        EndAt = endAt;
    }

    public com.bees.OrderFood.model.Dish getDish() {
        return Dish;
    }

    public void setDish(com.bees.OrderFood.model.Dish dish) {
        Dish = dish;
    }

    public Long getDishId() {
        return DishId;
    }

    public void setDishId(Long dishId) {
        DishId = dishId;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}

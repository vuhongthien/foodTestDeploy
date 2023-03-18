package com.bees.OrderFood.model;

import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_bill")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bill_id")
    private Long BillId;
    @ManyToOne(optional=false)
    @JoinColumn(name = "user_id", insertable=false, updatable=false)
    @ToString.Exclude
    private User User;
    @Column(name = "user_id", nullable = false)
    private Long UserId;
    @Column(name = "bill_day_set")
    private LocalDateTime DaySet;
    @Column(name = "bill_total_price")
    private Double TotalPrice;

    public Bill(Long billId, com.bees.OrderFood.model.User user, Long userId, LocalDateTime daySet, Double totalPrice) {
        BillId = billId;
        User = user;
        UserId = userId;
        DaySet = daySet;
        TotalPrice = totalPrice;
    }

    public Bill() {
    }

    public Long getBillId() {
        return BillId;
    }

    public void setBillId(Long billId) {
        BillId = billId;
    }

    public com.bees.OrderFood.model.User getUser() {
        return User;
    }

    public void setUser(com.bees.OrderFood.model.User user) {
        User = user;
    }

    public LocalDateTime getDaySet() {
        return DaySet;
    }

    public void setDaySet(LocalDateTime daySet) {
        DaySet = daySet;
    }

    public Double getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        TotalPrice = totalPrice;
    }

    public Long getUserId() {
        return UserId;
    }

    public void setUserId(Long userId) {
        UserId = userId;
    }
}

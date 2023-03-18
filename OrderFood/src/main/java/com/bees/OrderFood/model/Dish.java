package com.bees.OrderFood.model;

import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity

@Table(name = "tbl_dish")
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dish_id")
    private Long DishId;
    @ManyToOne(optional=false)
    @JoinColumn(name = "type_dish_id", insertable=false, updatable=false)
    @ToString.Exclude
    private DishType DishType;
    @Column(name = "type_dish_id", nullable=false)
    private Long DishTypeId;
    @Column(name = "dish_star")
    private int Star;
    @Column(name = "dish_bought")
    private  int Bought;
    @Column(name = "dish_image")
    private  String image;
    @Column(name = "dish_discount")
    private  float discount;
    @Column(name = "dish_name")
    private String DishName;
    @Column(name = "dish_price")
    private float Price;
    @Column(name = "dish_quantity")
    private Long Quantity;
    @Column(name = "dish_create_at")
    private LocalDateTime CreateAt;
    @Column(name = "dish_end_at")
    private LocalDateTime EndAt;
    @Column(name = "dish_active")
    private int Active;

    public Dish(Long dishId, com.bees.OrderFood.model.DishType dishType, Long dishTypeId, com.bees.OrderFood.model.Voucher voucher, int star, int bought, String image, float discount, String dishName, float price, Long quantity, LocalDateTime createAt, LocalDateTime endAt, int active) {
        DishId = dishId;
        DishType = dishType;
        DishTypeId = dishTypeId;

        Star = star;
        Bought = bought;
        this.image = image;
        this.discount = discount;
        DishName = dishName;
        Price = price;
        Quantity = quantity;
        CreateAt = createAt;
        EndAt = endAt;
        Active = active;
    }

    public Dish() {
    }

    public Long getDishId() {
        return DishId;
    }

    public void setDishId(Long dishId) {
        DishId = dishId;
    }

    public com.bees.OrderFood.model.DishType getDishType() {
        return DishType;
    }

    public void setDishType(com.bees.OrderFood.model.DishType dishType) {
        DishType = dishType;
    }

    public Long getDishTypeId() {
        return DishTypeId;
    }

    public void setDishTypeId(Long dishTypeId) {
        DishTypeId = dishTypeId;
    }


    public int getStar() {
        return Star;
    }

    public void setStar(int star) {
        Star = star;
    }

    public int getBought() {
        return Bought;
    }

    public void setBought(int bought) {
        Bought = bought;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public String getDishName() {
        return DishName;
    }

    public void setDishName(String dishName) {
        DishName = dishName;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float price) {
        Price = price;
    }

    public Long getQuantity() {
        return Quantity;
    }

    public void setQuantity(Long quantity) {
        Quantity = quantity;
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

    public int getActive() {
        return Active;
    }

    public void setActive(int active) {
        Active = active;
    }
}

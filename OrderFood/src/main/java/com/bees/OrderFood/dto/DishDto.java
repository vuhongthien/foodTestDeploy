package com.bees.OrderFood.dto;

import java.time.LocalDateTime;

public class DishDto {
    private Long DishId;


    private Long DishTypeId;
    private int Star;

    private  int Bought;

    private  String image;

    private  float discount;

    private String DishName;

    private float Price;

    private Long Quantity;

    private LocalDateTime CreateAt;

    private LocalDateTime EndAt;

    private int Active;

    public DishDto(Long dishId, Long dishTypeId, int star, int bought, String image, float discount, String dishName, float price, Long quantity, LocalDateTime createAt, LocalDateTime endAt, int active) {
        DishId = dishId;
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

    public DishDto() {
    }

    public Long getDishId() {
        return DishId;
    }

    public void setDishId(Long dishId) {
        DishId = dishId;
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

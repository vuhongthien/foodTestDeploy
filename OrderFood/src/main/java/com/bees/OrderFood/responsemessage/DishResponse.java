package com.bees.OrderFood.responsemessage;

import java.time.LocalDateTime;

public class DishResponse {
    private Long DishId;
    private  String image;
    private  float discount;
    private String DishName;
    private float Price;
    private Long Quantity;
    private LocalDateTime CreateAt;
    private LocalDateTime EndAt;
    private String TypeDishName;
    private double realprice;



    public DishResponse() {
    }

    public DishResponse(Long dishId, String image, float discount, String dishName, float price, Long quantity, LocalDateTime createAt, LocalDateTime endAt, String typeDishName, double realprice) {
        DishId = dishId;
        this.image = image;
        this.discount = discount;
        DishName = dishName;
        Price = price;
        Quantity = quantity;
        CreateAt = createAt;
        EndAt = endAt;
        TypeDishName = typeDishName;
        this.realprice = realprice;
    }

    public Long getDishId() {
        return DishId;
    }

    public void setDishId(Long dishId) {
        DishId = dishId;
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

    public String getTypeDishName() {
        return TypeDishName;
    }

    public void setTypeDishName(String typeDishName) {
        TypeDishName = typeDishName;
    }

    public double getRealprice() {
        return realprice;
    }

    public void setRealprice(double realprice) {
        this.realprice = realprice;
    }
}

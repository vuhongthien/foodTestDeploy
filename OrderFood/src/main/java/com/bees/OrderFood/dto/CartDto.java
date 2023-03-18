package com.bees.OrderFood.dto;


public class CartDto {
    private  Long DishId;
    private int quanty;
    private double totalPrice;
    private DishDto dishDto;

    public CartDto(Long dishId, int quanty, double totalPrice, DishDto dishDto) {
        DishId = dishId;
        this.quanty = quanty;
        this.totalPrice = totalPrice;
        this.dishDto = dishDto;
    }

    public CartDto() {
    }

    public Long getDishId() {
        return DishId;
    }

    public void setDishId(Long dishId) {
        DishId = dishId;
    }

    public int getQuanty() {
        return quanty;
    }

    public void setQuanty(int quanty) {
        this.quanty = quanty;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public DishDto getDishDto() {
        return dishDto;
    }

    public void setDishDto(DishDto dishDto) {
        this.dishDto = dishDto;
    }
}

package com.bees.OrderFood.responsemessage;

import com.bees.OrderFood.dto.DishDto;

public class CartResponse {
    private  Long DishId;
    private int quanty;
    private double totalPrice;
    private DishDto dishDto;
    private double AllPrice;
    private Long AllQuanty;

    public CartResponse(Long dishId, int quanty, double totalPrice, DishDto dishDto, double allPrice, Long allQuanty) {
        DishId = dishId;
        this.quanty = quanty;
        this.totalPrice = totalPrice;
        this.dishDto = dishDto;
        AllPrice = allPrice;
        AllQuanty = allQuanty;
    }

    public CartResponse() {
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

    public double getAllPrice() {
        return AllPrice;
    }

    public void setAllPrice(double allPrice) {
        AllPrice = allPrice;
    }

    public Long getAllQuanty() {
        return AllQuanty;
    }

    public void setAllQuanty(Long allQuanty) {
        AllQuanty = allQuanty;
    }
}

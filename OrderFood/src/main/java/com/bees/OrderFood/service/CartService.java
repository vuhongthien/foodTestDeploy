package com.bees.OrderFood.service;

import com.bees.OrderFood.dto.CartDto;

import java.util.Collection;
import java.util.Map;

public interface CartService {
     Map<Long, CartDto> AddCart(CartDto cartDto);

     Map<Long, CartDto> EditCart(Long id,int quanty);

     Map<Long, CartDto> DeleteCart(Long id);
     void  DeleteCartAll();
     Collection<CartDto> showall();

     int TotalQuanty();

     double TotalPrice();
}

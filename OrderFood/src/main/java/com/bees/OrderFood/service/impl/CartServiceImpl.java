package com.bees.OrderFood.service.impl;

import com.bees.OrderFood.dto.CartDto;
import com.bees.OrderFood.dto.DishDto;
import com.bees.OrderFood.service.CartService;
import com.bees.OrderFood.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static com.bees.OrderFood.utils.TotalPriceUtils.TotalPriceCart;

@Service
@SessionScope
public class CartServiceImpl implements CartService {
    @Autowired
    DishService dishService;
    Map<Long, CartDto> cart = new HashMap<>();
    @Override
    public Map<Long, CartDto> AddCart(CartDto cartDto ) {
        CartDto itemCart = new CartDto();
        DishDto dishDto = dishService.findByIdDto(cartDto.getDishId());
        if(dishDto != null && cart.containsKey(cartDto.getDishId())) {
            itemCart = cart.get(cartDto.getDishId());
            itemCart.setQuanty(itemCart.getQuanty() + 1);
            itemCart.setTotalPrice(TotalPriceCart(itemCart.getQuanty(),itemCart.getDishDto().getPrice()- dishDto.getDiscount()));
        }
        else {
            itemCart.setDishDto(dishDto);
            itemCart.setQuanty(1);
            itemCart.setDishId(cartDto.getDishId());
            itemCart.setTotalPrice(itemCart.getDishDto().getPrice()- dishDto.getDiscount());
        }
        cart.put(cartDto.getDishId(), itemCart);
        return cart;
    }

    @Override
    public Map<Long, CartDto> EditCart(Long id, int quanty) {
        if(cart == null) {
            return cart;
        }
        CartDto itemCart = new CartDto();
        DishDto dishDto = dishService.findByIdDto(id);
        if(dishDto != null && cart.containsKey(id)) {
            itemCart = cart.get(id);
            itemCart.setQuanty(quanty);
            itemCart.setTotalPrice(TotalPriceCart(itemCart.getQuanty(),itemCart.getDishDto().getPrice()-dishDto.getDiscount()));
        }
        cart.put(id, itemCart);
        return cart;
    }

    @Override
    public Map<Long, CartDto> DeleteCart(Long id) {
        if(cart == null) {
            return cart;
        }
        if(cart.containsKey(id)) {
            cart.remove(id);
        }
        return cart;
    }

    @Override
    public void DeleteCartAll() {
        cart.clear();
    }

    @Override
    public Collection<CartDto> showall() {
        return cart.values();
    }

    @Override
    public int TotalQuanty() {
        int totalQuanty = 0;
        for(Map.Entry<Long, CartDto> itemCart : cart.entrySet()) {
            totalQuanty += itemCart.getValue().getQuanty();
        }
        return totalQuanty;
    }
    @Override
    public double TotalPrice() {
        double totalPrice = 0;
        for(Map.Entry<Long, CartDto> itemCart : cart.entrySet()) {
            totalPrice += itemCart.getValue().getTotalPrice();
        }
        return totalPrice;
    }

}

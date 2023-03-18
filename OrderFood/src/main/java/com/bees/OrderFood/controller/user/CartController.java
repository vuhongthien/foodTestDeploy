package com.bees.OrderFood.controller.user;

import com.bees.OrderFood.dto.CartDto;
import com.bees.OrderFood.dto.DishDto;
import com.bees.OrderFood.responsemessage.CartResponse;
import com.bees.OrderFood.service.impl.CartServiceImpl;
import com.bees.OrderFood.service.impl.DishServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class CartController {
    @Autowired
    CartServiceImpl cartService;
    @Autowired
    DishServiceImpl dishService;
    @PostMapping(value = "/add-cart")
    public Collection<CartDto> addcart(@RequestParam("dishid") Long dishid) {
        DishDto dishDto = dishService.findByIdDto(dishid);
           CartDto cartDto = new CartDto();
           cartDto.setDishId(dishid);
           cartDto.setQuanty(1);
           cartDto.setTotalPrice(dishDto.getPrice());
        cartService.AddCart(cartDto);
        cartService.TotalQuanty();
        cartService.TotalPrice();
        return cartService.showall();
    }
    @PutMapping(value = "/edit-cart")
    public Collection<CartDto> editcart(@RequestParam("dishid") Long dishid,
                                       @RequestParam("quanty") int quanty) {
        cartService.EditCart(dishid, quanty);
        cartService.TotalQuanty();
        cartService.TotalPrice();
        return cartService.showall();
    }
    @DeleteMapping(value = "/delete-cart")
    public Collection<CartDto> deletecart(@RequestParam("dishid") Long dishid) {
        cartService.DeleteCart(dishid);
        cartService.TotalQuanty();
        cartService.TotalPrice();
        return cartService.showall();
    }
    @GetMapping(value = "/get-cart")
    public Collection<CartResponse> getallcart() {
        Collection<CartResponse> list = cartService.showall().stream().map(t->{
            return new CartResponse(t.getDishId(),t.getQuanty(),t.getTotalPrice(),t.getDishDto(),cartService.TotalPrice(), (long) cartService.TotalQuanty());
        }).collect(Collectors.toList());
        return list;
    }
}

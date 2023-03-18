package com.bees.OrderFood.service;

import com.bees.OrderFood.dto.DishDto;
import com.bees.OrderFood.model.Dish;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface DishService {
    Page<Dish> findAllDish(Pageable pageable);
    Dish create(Dish dish);
    Dish findById(Long id);
    DishDto findByIdDto(Long id);
    DishDto findAllDto();
    void delete(Long id);

}

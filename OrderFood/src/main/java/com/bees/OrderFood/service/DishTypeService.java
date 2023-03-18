package com.bees.OrderFood.service;

import com.bees.OrderFood.model.DishType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface DishTypeService {
    List<DishType> findAllDishType();
    DishType create(DishType dishType);
    DishType findById(Long id);
    void delete(Long id);

}

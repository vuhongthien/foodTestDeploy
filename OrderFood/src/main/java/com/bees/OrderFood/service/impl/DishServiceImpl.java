package com.bees.OrderFood.service.impl;

import com.bees.OrderFood.dto.DishDto;

import com.bees.OrderFood.model.Dish;
import com.bees.OrderFood.repository.DishRepository;
import com.bees.OrderFood.service.DishService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishServiceImpl implements DishService {
    @Autowired
    private DishRepository dishRepository;
    @Autowired
    private ModelMapper mapper;



    @Override
    public Page<Dish> findAllDish(Pageable pageable) {
        return dishRepository.findAll(pageable);
    }

    @Override
    public Dish create(Dish dish) {
        return dishRepository.save(dish);
    }

    @Override
    public Dish findById(Long id) {
        return dishRepository.findById(id).get();
    }

    @Override
    public DishDto findByIdDto(Long id) {
        Dish dish = dishRepository.findById(id).get();
        return mapper.map(dish, DishDto.class);
    }

    @Override
    public DishDto findAllDto() {
        List<Dish> dish = dishRepository.findAll();
        return mapper.map(dish, DishDto.class);
    }

    @Override
    public void delete(Long id) {
        dishRepository.deleteById(id);
    }
}

package com.bees.OrderFood.repository;

import com.bees.OrderFood.model.Dish;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface DishRepository extends JpaRepository<Dish,Long> {
}

package com.bees.OrderFood.repository;

import com.bees.OrderFood.model.DishType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DishTypeRepository extends JpaRepository<DishType, Long> {
}

package com.bees.OrderFood.model;
import javax.persistence.*;

@Entity
@Table(name = "tbl_dish_type")
public class DishType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_dish_id")
    private Long TypeDishId;
    @Column(name = "type_dish_name")
    private String TypeDishName;
    @Column(name = "type_dish_active")
    private int Active;

    public DishType(Long typeDishId, String typeDishName, int active) {
        TypeDishId = typeDishId;
        TypeDishName = typeDishName;
        Active = active;
    }

    public DishType() {
    }

    public Long getTypeDishId() {
        return TypeDishId;
    }

    public void setTypeDishId(Long typeDishId) {
        TypeDishId = typeDishId;
    }

    public String getTypeDishName() {
        return TypeDishName;
    }

    public void setTypeDishName(String typeDishName) {
        TypeDishName = typeDishName;
    }

    public int getActive() {
        return Active;
    }

    public void setActive(int active) {
        Active = active;
    }
}

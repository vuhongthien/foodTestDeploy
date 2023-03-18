package com.bees.OrderFood.model;

import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "tbl_image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private Long ImageId;
    @Column(name = "image_path")
    private  String ImagePath;
    @Column(name = "image_name")
    private  String ImageName;
    @Column(name = "image_active")
    private int Active;
    @ManyToOne(optional=false)
    @JoinColumn(name = "dish_id", insertable=false, updatable=false)
    @ToString.Exclude
    private Dish Dish;
    @Column(name = "dish_id", nullable=false)
    private Long DishId;


    public Image(Long imageId, String imagePath, String imageName, int active, com.bees.OrderFood.model.Dish dish, Long dishId) {
        ImageId = imageId;
        ImagePath = imagePath;
        ImageName = imageName;
        Active = active;
        Dish = dish;
        DishId = dishId;
    }

    public Image() {
    }

    public Long getImageId() {
        return ImageId;
    }

    public void setImageId(Long imageId) {
        ImageId = imageId;
    }

    public String getImagePath() {
        return ImagePath;
    }

    public void setImagePath(String imagePath) {
        ImagePath = imagePath;
    }

    public String getImageName() {
        return ImageName;
    }

    public void setImageName(String imageName) {
        ImageName = imageName;
    }

    public int getActive() {
        return Active;
    }

    public void setActive(int active) {
        Active = active;
    }

    public com.bees.OrderFood.model.Dish getDish() {
        return Dish;
    }

    public void setDish(com.bees.OrderFood.model.Dish dish) {
        Dish = dish;
    }

    public Long getDishId() {
        return DishId;
    }

    public void setDishId(Long dishId) {
        DishId = dishId;
    }
}

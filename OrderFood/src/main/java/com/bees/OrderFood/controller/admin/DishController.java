package com.bees.OrderFood.controller.admin;

import com.bees.OrderFood.responsemessage.DishResponse;
import com.bees.OrderFood.model.Dish;
import com.bees.OrderFood.model.DishType;
import com.bees.OrderFood.service.impl.DishServiceImpl;
import com.bees.OrderFood.service.impl.DishTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

import static com.bees.OrderFood.utils.DishUtils.disCount;

@RestController
@RequestMapping("/api")
public class DishController {
    @Autowired
    DishServiceImpl dishService;
    @Autowired
    DishTypeServiceImpl dishTypeService;

    @GetMapping("/list-dish/{pageNumber}/{pageSize}")
    public Page<Dish> listall(@PathVariable(name = "pageNumber") Integer pageNumber,
                              @PathVariable(name = "pageSize") Integer pageSize){
        return dishService.findAllDish(PageRequest.of(pageNumber,pageSize));
    }
    @PostMapping("/add-dish")
    public DishResponse adddish(@RequestParam("type_dish_id") Long typedishid,
                                @RequestParam("dish_image") MultipartFile dishimage,
                                @RequestParam("dish_discount") float dishdiscount,
                                @RequestParam("dish_name") String dishname,
                                @RequestParam("dish_price") float dishprice,
                                @RequestParam("dish_quantity") Long dishquantity,
                                @RequestParam("dish_end_at") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dishendat

                            ){
        Dish dish = new Dish();
        dish.setImage(dishimage.getOriginalFilename());
        dish.setDiscount(dishdiscount);
        dish.setDishName(dishname);
        dish.setPrice(dishprice);
        dish.setQuantity(dishquantity);
        dish.setCreateAt(LocalDateTime.now());
        dish.setEndAt(dishendat);
        dish.setActive(1);
        dish.setDishTypeId(typedishid);
        Dish d = dishService.create(dish);
        DishType dt = dishTypeService.findById(d.getDishTypeId());
        String nameDishtype = dt.getTypeDishName();

        return new DishResponse(d.getDishId(),d.getImage(),dishdiscount,dishname,dishprice,dishquantity,d.getCreateAt(),dishendat,nameDishtype,disCount(d.getPrice(),d.getDiscount()));
    }
    @PutMapping("/edit-dish")
    public DishResponse editdish(@RequestParam("type_dish_id") Long typedishid,
                                 @RequestParam("dish_id") Long dishid,
                                 @RequestParam("dish_image") MultipartFile dishimage,
                                 @RequestParam("dish_discount") float dishdiscount,
                                 @RequestParam("dish_name") String dishname,
                                 @RequestParam("dish_price") float dishprice,
                                 @RequestParam("dish_quantity") Long dishquantity,
                                 @RequestParam("dish_end_at") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dishendat,
                                 @RequestParam("dish_active") int dishactive){
        Dish dish = dishService.findById(dishid);
        dish.setImage(dishimage.getName());
        dish.setDiscount(dishdiscount);
        dish.setDishName(dishname);
        dish.setPrice(dishprice);
        dish.setQuantity(dishquantity);
        dish.setEndAt(dishendat);
        dish.setActive(dishactive);
        dish.setDishTypeId(typedishid);
        Dish d = dishService.create(dish);
        DishType dt = dishTypeService.findById(d.getDishTypeId());
        String nameDishtype = dt.getTypeDishName();

        return new DishResponse(d.getDishId(),dishimage.getName(),dishdiscount,dishname,dishprice,dishquantity,d.getCreateAt(),dishendat,nameDishtype,disCount(d.getPrice(),d.getDiscount()));
    }
    @DeleteMapping("/drop-dish")
    public ResponseEntity dropdish(@RequestParam("dish_id") Long id){
        dishService.delete(id);
        return new ResponseEntity<>( HttpStatus.OK);
    }
}

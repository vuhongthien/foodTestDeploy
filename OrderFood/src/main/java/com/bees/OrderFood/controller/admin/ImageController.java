package com.bees.OrderFood.controller.admin;

import com.bees.OrderFood.model.Image;
import com.bees.OrderFood.service.impl.ImageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
public class ImageController {
    @Autowired
    ImageServiceImpl imageService;
    @GetMapping("/list-image/{pageNumber}/{pageSize}")
    public Page<Image> listall(@PathVariable(name = "pageNumber") Integer pageNumber,
                               @PathVariable(name = "pageSize") Integer pageSize){
        return imageService.findAllImage(PageRequest.of(pageNumber,pageSize));
    }
    @PostMapping("/add-image")
    public Image addimage(@RequestParam("image_name") MultipartFile imagename){
        Image image = new Image();
        image.setImageName(imagename.getName());
        image.setActive(1);
        image.setImagePath("hé lô");
        return imageService.create(image);
    }
    @PutMapping("/edit-image")
    public Image editdishtype(@RequestParam("image_name") MultipartFile imagename,
                                 @RequestParam("Active")int active,
                                 @RequestParam("id") Long id){
        Image image = imageService.findById(id);
        image.setImageName(imagename.getName());
        image.setActive(active);
        image.setImagePath("hé lô");
        return imageService.create(image);
    }
    @DeleteMapping("/drop-image")
    public ResponseEntity dropdishtype(@RequestParam("id") Long id){
        imageService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

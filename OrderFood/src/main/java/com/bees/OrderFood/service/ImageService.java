package com.bees.OrderFood.service;

import com.bees.OrderFood.model.Image;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ImageService {
    Page<Image> findAllImage(Pageable pageable);
    Image create(Image image);
    Image findById(Long id);
    void delete(Long id);
}

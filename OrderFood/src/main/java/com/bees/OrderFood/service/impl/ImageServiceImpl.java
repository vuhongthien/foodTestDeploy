package com.bees.OrderFood.service.impl;

import com.bees.OrderFood.model.Image;
import com.bees.OrderFood.repository.ImageRepository;
import com.bees.OrderFood.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    private ImageRepository imageRepository;
    @Override
    public Page<Image> findAllImage(Pageable pageable) {
        return imageRepository.findAll(pageable);
    }

    @Override
    public Image create(Image image) {
        return imageRepository.save(image);
    }

    @Override
    public Image findById(Long id) {
        return imageRepository.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        imageRepository.deleteById(id);
    }
}

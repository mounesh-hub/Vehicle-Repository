package com.mounesh.root.service;

import com.mounesh.root.jpa.BikeRepository;
import com.mounesh.root.model.Bike;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class BikeService {

    @Autowired
    private BikeRepository bikeRepository;
    private Logger logger = LoggerFactory.getLogger(BikeService.class);

    public List<Bike> getAllBikes(Pageable paging) {
        logger.info("inside BikeService#getAllBikes");
        logger.info("paging =", paging);
        Page<Bike> page = bikeRepository.findAll(paging);
        if (page.hasContent()) {
            return page.getContent();
        } else {
            return Collections.emptyList();
        }
    }

    public Bike saveBike(Bike bike){
        logger.info("inside BikeService#saveBike", bike);
        bikeRepository.save(bike);
        return bike;
    }
}

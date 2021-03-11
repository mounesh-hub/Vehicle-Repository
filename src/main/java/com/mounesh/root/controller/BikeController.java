package com.mounesh.root.controller;

import com.mounesh.root.model.Bike;
import com.mounesh.root.service.BikeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bikes")
public class BikeController {

    @Autowired
    private BikeService bikeService;
    private Logger logger = LoggerFactory.getLogger(BikeController.class);

    @GetMapping
    public List<Bike> getAllBikes(@RequestParam(name = "page", required = false, defaultValue = "0") int page,
                                  @RequestParam(name = "size", required = false, defaultValue = "10") int size,
                                  @RequestParam(name = "sortBy", required = false, defaultValue = "bikeName") String sortBy,
                                  @RequestParam(name = "sortDr", required = false, defaultValue = "ASC") String sortDr) {
        logger.info("inside BikeController#getAllBikes");
        Sort sorting = Sort.by(sortBy);
        sorting = (sortDr.equalsIgnoreCase("asc")) ? sorting.ascending() : sorting.descending();
        Pageable paging = PageRequest.of(page, size, sorting);
        return bikeService.getAllBikes(paging);
    }

    @PostMapping
    public ResponseEntity<Bike> saveBike(@RequestBody Bike bike) {
        System.out.println(bike);
        Bike createdBike = bikeService.saveBike(bike);
        return new ResponseEntity<>(createdBike, HttpStatus.CREATED);
    }
}

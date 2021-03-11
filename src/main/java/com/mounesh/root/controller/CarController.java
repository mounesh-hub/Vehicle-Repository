package com.mounesh.root.controller;

import com.mounesh.root.model.Car;
import com.mounesh.root.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    CarService service;

    @GetMapping()
    public CollectionModel<EntityModel<Car>> getAllCars(@RequestParam(value = "filter", defaultValue = "all") String filter) {
        List<EntityModel<Car>> allCars = new ArrayList<>();
        for(Car car: service.getAllCars(filter)){
            EntityModel<Car> entityModel = new EntityModel(car, linkTo(methodOn(CarController.class).getCarById(car.getId())).
                    withSelfRel(),
                    linkTo(methodOn(CarController.class).getAllCars("")).withRel("all"));
            allCars.add(entityModel);
        }
        return new CollectionModel(allCars, linkTo(methodOn(CarController.class).getAllCars("")).withSelfRel());
    }

    @GetMapping("/{id}")
    public EntityModel<Car> getCarById(@PathVariable("id") long id) {
        return new EntityModel(service.getCarById(id), linkTo(methodOn(CarController.class).getCarById(id)).
                withSelfRel(),
                linkTo(methodOn(CarController.class).getAllCars("")).withRel("all"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EntityModel<Car> addCar(@RequestBody Car car) {
        Car newCar = service.addCar(car);
        return new EntityModel(newCar, linkTo(methodOn(CarController.class).getCarById(newCar.getId())).
                withSelfRel(),
                linkTo(methodOn(CarController.class).getAllCars("")).withRel("all"));
    }

    @PutMapping
    public EntityModel<Car> updateCar(@RequestBody Car car) {
        Car newCar = service.updateCar(car);
        return new EntityModel(newCar, linkTo(methodOn(CarController.class).getCarById(newCar.getId())).
                withSelfRel(),
                linkTo(methodOn(CarController.class).getAllCars("")).withRel("all"));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCar(@PathVariable("id") long id) {
        service.deleteCarById(id);
    }

}

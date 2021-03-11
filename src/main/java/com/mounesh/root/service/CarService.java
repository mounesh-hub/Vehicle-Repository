package com.mounesh.root.service;

import com.mounesh.root.exception.CarNotFoundException;
import com.mounesh.root.jpa.CarRepository;
import com.mounesh.root.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CarService {

    @Autowired
    CarRepository repo;

    public List<Car> getAllCars(String filter) {
        if (filter != null) {
            String[] filterParams = filter.split(":");
            if (filterParams[0].equalsIgnoreCase("name")) {
                return repo.findByName(filterParams[1]);
            } else if (filterParams[0].equalsIgnoreCase("model")) {
                return repo.findByModel(filterParams[1]);
            } else if (filterParams[0].equalsIgnoreCase("manufacturerName")) {
                return repo.findByManufacturerName(filterParams[1]);
            } else if (filterParams[0].equalsIgnoreCase("color")) {
                return repo.findByColor(filterParams[1]);
            }
            else if(filterParams[0].equalsIgnoreCase("all")){
                return repo.findAll();
            }
        }
        return Collections.emptyList();
    }

    public Car getCarById(long id) {
        return repo.findById(id).orElseThrow(() -> new CarNotFoundException("Car not fount for the id: "+id));
    }

    public Car addCar(Car car) {
        return repo.save(car);
    }

    public Car updateCar(Car car) {
        return repo.save(car);
    }

    public void deleteCarById(long id) {
        repo.deleteById(id);
    }
}

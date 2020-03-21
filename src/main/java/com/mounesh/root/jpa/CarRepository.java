package com.mounesh.root.jpa;

import com.mounesh.root.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    public List<Car> findByName(String name);
    public List<Car> findByModel(String name);
    public List<Car> findByManufacturerName(String name);
    public List<Car> findByColor(String name);
    public List<Car> findByManufacturingYear(Date date);
    public List<Car> findByManufacturingYearBefore(Date date);
    public List<Car> findByManufacturingYearAfter(Date date);
}

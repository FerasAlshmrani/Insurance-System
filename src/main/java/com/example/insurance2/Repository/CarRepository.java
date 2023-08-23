package com.example.insurance2.Repository;

import com.example.insurance2.Model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car,Integer> {
    Car findCarInfoById(Integer id);

    Car findCarInfoBySerialNumber(Integer serialNumber);

    Car findCarInfoByCarModel(Integer carModel);
}

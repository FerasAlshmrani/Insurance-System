package com.example.insurance2.Repository;

import com.example.insurance2.Model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car,Integer> {
    Car findCarInfoById(Integer id);

    Car findCarInfoBySerialNumber(Integer serialNumber);

    Car findCarInfoByCarModel(Integer carModel);

    @Query("select c from Car c where c.carModel < 2006")
    List<Car> findAllByCarModelLessThan2006();
}

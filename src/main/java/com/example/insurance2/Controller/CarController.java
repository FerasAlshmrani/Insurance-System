package com.example.insurance2.Controller;

import com.example.insurance2.Api.ApiResponse;
import com.example.insurance2.DTO.CarDTO;
import com.example.insurance2.Model.Car;
import com.example.insurance2.Service.CarService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/v1/car")
@RequiredArgsConstructor
public class CarController {
    private final CarService carInfoService;
    @GetMapping("/get")
    public ResponseEntity getAllCars(){
        return ResponseEntity.status(200).body(carInfoService.getAllCars());
    }

    @PostMapping("/add")
    public ResponseEntity addCar(@RequestBody @Valid CarDTO carDTO){
        carInfoService.addCar(carDTO);

        return ResponseEntity.status(200).body("Car Added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id, @RequestBody @Valid CarDTO carDTO){
        carInfoService.updateCar(id,carDTO);
        return ResponseEntity.status(200).body(new ApiResponse("Car updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCar(@PathVariable Integer id){
        carInfoService.removeCar(id);
        return ResponseEntity.status(200).body("Car Delete");
    }

    @GetMapping("/get-car-by-model/{carModel}")
    public ResponseEntity getCarByModel(@PathVariable Integer carModel){
        Car carInfo = carInfoService.getCarByModel(carModel);
        return ResponseEntity.status(200).body(carInfo);
    }

    @GetMapping("/get-by-serial/{serial}")
    public ResponseEntity getCarBySerialNumber(@PathVariable Integer serial){
        Car car = carInfoService.getCarBySerialNumber(serial);

        return ResponseEntity.status(200).body(car);
    }
    @PutMapping("/{user_id}/assign/{car_id}")
    public ResponseEntity assignUserToCar(@PathVariable Integer user_id, @PathVariable Integer car_id){
        carInfoService.assignUserToCar(user_id, car_id);
        return ResponseEntity.status(200).body("assign Done");
    }
    @GetMapping("/get-less-model")
    public ResponseEntity getallCarLessThan2006(){
        return ResponseEntity.status(200).body(carInfoService.getAllCarLessThan2006());
    }
}

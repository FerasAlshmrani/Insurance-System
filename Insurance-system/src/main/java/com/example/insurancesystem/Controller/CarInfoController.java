package com.example.insurancesystem.Controller;

import com.example.insurancesystem.Api.ApiResponse;
import com.example.insurancesystem.Model.CarInfo;

import com.example.insurancesystem.Service.CarInfoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/car")
@RequiredArgsConstructor
public class CarInfoController {
    private final CarInfoService carInfoService;
    @GetMapping("/get")
    public ResponseEntity getAllCars(){
        return ResponseEntity.status(200).body(carInfoService.getAllCars());
    }

    @PostMapping("/add")
    public ResponseEntity addCar(@RequestBody @Valid CarInfo car){
        carInfoService.addCar(car);

        return ResponseEntity.status(200).body("Car Added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id, @RequestBody @Valid CarInfo car){
        carInfoService.updateCar(id,car);
        return ResponseEntity.status(200).body(new ApiResponse("Car updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCar(@PathVariable Integer id){
        carInfoService.removeCar(id);
        return ResponseEntity.status(200).body("Car Delete");
    }

    @GetMapping("/get-car-by-model/{carModel}")
    public ResponseEntity getCarByModel(@PathVariable Integer carModel){
        CarInfo carInfo = carInfoService.getCarByModel(carModel);
        return ResponseEntity.status(200).body(carInfo);
    }

    @GetMapping("/get-by-serial/{serial}")
    public ResponseEntity getCarBySerialNumber(@PathVariable Integer serial){
        CarInfo car = carInfoService.getCarBySerialNumber(serial);

        return ResponseEntity.status(200).body(car);
    }
}

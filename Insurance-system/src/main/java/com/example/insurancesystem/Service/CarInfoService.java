package com.example.insurancesystem.Service;

import com.example.insurancesystem.Api.ApiException;
import com.example.insurancesystem.Model.CarInfo;
import com.example.insurancesystem.Repository.CarInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarInfoService {
    private final CarInfoRepository carInfoRepository;
    public List<CarInfo> getAllCars(){
        return carInfoRepository.findAll();
    }

    public void addCar(CarInfo car){
        carInfoRepository.save(car);
    }

    public void updateCar(Integer id, CarInfo carInfo){
        CarInfo carInfo1 = carInfoRepository.findCarInfoById(id);

        if (carInfo1 == null ){
            throw new ApiException("Car Id Not found");
        }

        carInfo1.setCarName(carInfo.getCarName());
        carInfo1.setCarModel(carInfo.getCarModel());
        carInfo1.setSerialNumber(carInfo.getSerialNumber());
        carInfoRepository.save(carInfo1);
    }

    public void removeCar(Integer id){
            CarInfo carInfo = carInfoRepository.findCarInfoById(id);
        if (carInfo == null ){
            throw new ApiException("Car Id Not found");
        }

        carInfoRepository.delete(carInfo);
    }

   public CarInfo getCarBySerialNumber(Integer serialNumber){
        CarInfo carInfo = carInfoRepository.findCarInfoBySerialNumber(serialNumber);

       if (carInfo == null ){
           throw new ApiException("Serial Number Not found");
       }
            return carInfo;
   }

   public CarInfo getCarByModel(Integer model){
        CarInfo carModel = carInfoRepository.findCarInfoByCarModel(model);
       if (carModel == null ){
           throw new ApiException("Model Not found");
       }
       return carModel;
   }
}

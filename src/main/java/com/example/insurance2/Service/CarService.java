package com.example.insurance2.Service;

import com.example.insurance2.Api.ApiException;
import com.example.insurance2.Model.Car;
import com.example.insurance2.Model.User;
import com.example.insurance2.Repository.CarRepository;
import com.example.insurance2.Repository.OrderUserRepository;
import com.example.insurance2.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;
    private final UserRepository userRepository;
    private final OrderUserRepository orderUserRepository;
    public List<Car> getAllCars(){
        return carRepository.findAll();
    }

    public void addCar(Car car){
        carRepository.save(car);
        }



    public void updateCar(Integer id, Car car){
        Car carInfo = carRepository.findCarInfoById(id);

        if(carInfo == null){
            throw new ApiException("Wrong carID");
        }


        carInfo.setCarName(car.getCarName());
        carInfo.setCarModel(car.getCarModel());
        carInfo.setSerialNumber(car.getSerialNumber());
        carInfo.setUser(car.getUser());
        carRepository.save(carInfo);
    }

    public void removeCar(Integer id){

        Car carInfo = carRepository.findCarInfoById(id);
        if (carInfo == null ){
            throw new ApiException("Car Id Not found");
        }


        carRepository.delete(carInfo);
    }

    public Car getCarBySerialNumber(Integer serialNumber){
        Car carInfo = carRepository.findCarInfoBySerialNumber(serialNumber);

        if (carInfo == null ){
            throw new ApiException("Serial Number Not found");
        }
        return carInfo;
    }

    public Car getCarByModel(Integer model){
        Car carModel = carRepository.findCarInfoByCarModel(model);
        if (carModel == null ){
            throw new ApiException("Model Not found");
        }
        return carModel;
    }
    public void assignUserToCar(Integer user_id, Integer car_id){
        User user = userRepository.findUserById(user_id);
        Car car = carRepository.findCarInfoById(car_id);
        if (user == null || car == null){
            throw new ApiException("No Assgin");
        }
        for (Car u : user.getCar()) {
            if(u.getId().equals(car.getId())){
                throw new ApiException("Already assgined");
            }
        }

        user.setCarQuntity(user.getCarQuntity()+1);
        car.setUser(user);
        carRepository.save(car);

    }
    public List<Car> getAllCarLessThan2006(){
        return carRepository.findAllByCarModelLessThan2006();
    }
}

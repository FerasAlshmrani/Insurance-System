package com.example.insurance2.Service;

import com.example.insurance2.Api.ApiException;
import com.example.insurance2.DTO.CarDTO;
import com.example.insurance2.Model.Car;
import com.example.insurance2.Model.OrderUser;
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

    public void addCar(CarDTO carDTO){
        OrderUser orderUser = orderUserRepository.findOrderUserById(carDTO.getOrder_Id());
        if(orderUser == null) {
            throw new ApiException("Order Id Not found");
        }
        Car car= new Car(null,carDTO.getCarName(),carDTO.getCarModel(),carDTO.getSerialNumber(),orderUser,carDTO.getUser());

        carRepository.save(car);
        }



    public void updateCar(Integer id, CarDTO carDTO){
        Car carInfo = carRepository.findCarInfoById(id);
        OrderUser orderUser = orderUserRepository.findOrderUserById(carDTO.getOrder_Id());

        if(carInfo == null){
            throw new ApiException("Wrong carID");
        }
        if(orderUser == null){
            throw new ApiException("Wrong Order Id");
        }

        carInfo.setCarName(carDTO.getCarName());
        carInfo.setCarModel(carDTO.getCarModel());
        carInfo.setSerialNumber(carDTO.getSerialNumber());
        carInfo.setUser(carDTO.getUser());
        carRepository.save(carInfo);
    }

    public void removeCar(Integer id){

        Car carInfo = carRepository.findCarInfoById(id);
        if (carInfo == null ){
            throw new ApiException("Car Id Not found");
        }

        CarDTO carDTO = new CarDTO(carInfo.getOrder().getId(),carInfo.getCarName(),carInfo.getCarModel(),carInfo.getSerialNumber(),carInfo.getUser());
        OrderUser orderUser = orderUserRepository.findOrderUserById(carDTO.getOrder_Id());
        if(orderUser.getCar() == null){
            throw new ApiException("this OrderId dont have car details to delete !");
        }

        orderUser.setCar(null);
        orderUserRepository.save(orderUser);
        carRepository.delete(carInfo);



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

        car.setUser(user);
        carRepository.save(car);

    }
}

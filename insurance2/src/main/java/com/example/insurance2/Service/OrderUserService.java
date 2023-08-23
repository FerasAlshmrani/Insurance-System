package com.example.insurance2.Service;

import com.example.insurance2.Api.ApiException;
import com.example.insurance2.Model.InsurancePackage;
import com.example.insurance2.Model.OrderUser;
import com.example.insurance2.Model.User;
import com.example.insurance2.Repository.CarRepository;
import com.example.insurance2.Repository.InsurancePackageRepository;
import com.example.insurance2.Repository.OrderUserRepository;
import com.example.insurance2.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderUserService {

    private final OrderUserRepository orderUserRepository;
    private final UserRepository userRepository;
    private final InsurancePackageRepository insurancePackageRepository;

    public List<OrderUser> getAllOrders(){
        return orderUserRepository.findAll();
    }

    public void addOrderUser(OrderUser orderUser,Integer user_id,Integer insurance_package_id){

        User user = userRepository.findUserById(user_id);
        InsurancePackage insurancePackage = insurancePackageRepository.findInsurancePackageById(insurance_package_id);
        if (user == null || insurancePackage == null){
            throw new ApiException("Wrong data");
        }

        orderUser.setUser(user);
        orderUser.setInsurance_package(insurancePackage);

        // insurance class
        orderUser.setInsurance_name(insurancePackage.getInsurance().getName());

        // insurancePackage class
        orderUser.setInsurancetype(insurancePackage.getInsurancetype());
        orderUser.setInsurancePrice(insurancePackage.getInsurancePrice());
        orderUser.setDuration(insurancePackage.getDuration());

        
       // orderUser.setCar(user.getCar());



        orderUserRepository.save(orderUser);
    }

    public void updateOrderUser(OrderUser orderUser , Integer id){
        OrderUser orderUser1 = orderUserRepository.findOrderUserById(id);
        if(orderUser1 == null){
            throw new ApiException("OrderUser");
        }
        orderUser1.setCar(orderUser.getCar());
        orderUser1.setInsurance_name(orderUser.getInsurance_package().getInsurance().getName());
        orderUser1.setEndDate(orderUser.getEndDate());

        orderUserRepository.save(orderUser1);


    }

    public void assaignOrderToUser(Integer user_id , Integer order_id){
        OrderUser orderUser = orderUserRepository.findOrderUserById(order_id);
        User user = userRepository.findUserById(user_id);


        if(orderUser == null || user_id == null){
            throw  new ApiException("Wrong Data");
        }

        orderUser.setUser(user);
        orderUserRepository.save(orderUser);

    }

    public void assignInsurancePackageToOrder(Integer insurancePackage_id , Integer order_id){
        OrderUser orderUser = orderUserRepository.findOrderUserById(order_id);
        InsurancePackage insurancePackage = insurancePackageRepository.findInsurancePackageById(insurancePackage_id);


        if(orderUser == null || insurancePackage_id == null){
            throw  new ApiException("Wrong Data");
        }

        orderUser.setInsurance_package(insurancePackage);
        orderUserRepository.save(orderUser);

    }
}

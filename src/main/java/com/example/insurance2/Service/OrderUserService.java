package com.example.insurance2.Service;

import com.example.insurance2.Api.ApiException;
import com.example.insurance2.Model.Car;
import com.example.insurance2.Model.InsurancePackage;
import com.example.insurance2.Model.OrderUser;
import com.example.insurance2.Model.User;
import com.example.insurance2.Repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class OrderUserService {

    private final OrderUserRepository orderUserRepository;
    private final InsuranceRepository insuranceRepository;

    public List<OrderUser> getAllOrders(){
        return orderUserRepository.findAll();
    }

    public void addOrderUser(User user , InsurancePackage insurancePackage, Set<Car> carSet){

        Date CurrentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = dateFormat.format(CurrentDate);

        if(user.getInsuranceSet().size() == 0){
            throw new ApiException("insurance name not found");
        }


        if(insuranceRepository.findInsuranceByName("walaa") != null){
            OrderUser orderUser = new OrderUser(null,"walaa",insurancePackage.getInsurancetype(),user.getRole(),formattedDate,
                    insurancePackage.getDuration(),user.getName(), user.getPhonenumber(),user.getCarQuntity(),insurancePackage.getInsurancePrice()* user.getCarQuntity(),user,insurancePackage);
            orderUserRepository.save(orderUser);

        } else if (insuranceRepository.findInsuranceByName("tawuniya") != null) {
            OrderUser orderUser = new OrderUser(null,"tawuniya",insurancePackage.getInsurancetype(),user.getRole(),formattedDate,
                    insurancePackage.getDuration(),user.getName(), user.getPhonenumber(),user.getCarQuntity(),insurancePackage.getInsurancePrice()* user.getCarQuntity(),user,insurancePackage);
            orderUserRepository.save(orderUser);

        } else if (insuranceRepository.findInsuranceByName("salama") != null) {
            OrderUser orderUser = new OrderUser(null,"salama",insurancePackage.getInsurancetype(),user.getRole(),formattedDate,
                    insurancePackage.getDuration(),user.getName(), user.getPhonenumber(),user.getCarQuntity(),insurancePackage.getInsurancePrice()* user.getCarQuntity(),user,insurancePackage);

            orderUserRepository.save(orderUser);
        }else{
            throw new ApiException("insurance name not found");
        }



        }

        public OrderUser findOrderUserById(Integer id){
        return orderUserRepository.findById(id).get();
        }
/*
        orderUser.setUser(user);
        orderUser.setInsurance_package(insurancePackage);*/

        // insurance class
//        orderUser.setInsurance_name(insurancePackage.getInsurance().getName());

        // insurancePackage class
/*
        orderUser.setInsurancetype(insurancePackage.getInsurancetype());
        orderUser.setInsurancePrice(insurancePackage.getInsurancePrice());
        orderUser.setDuration(insurancePackage.getDuration());
*/


        // orderUser.setCar(user.getCar());


        //orderUserRepository.save(orderUser);



/*
        orderUser1.setCar(orderUser.getCar());
        orderUser1.s(orderUser.getInsurance_package().getInsurance().getName());
        orderUser1.setEndDate(orderUser.getEndDate());
*/



}

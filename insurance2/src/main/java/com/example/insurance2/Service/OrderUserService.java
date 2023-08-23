package com.example.insurance2.Service;

import com.example.insurance2.Api.ApiException;
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
public class OrderUserService {

    private final OrderUserRepository orderUserRepository;
    private final UserRepository userRepository;

    public List<OrderUser> getAllOrders(){
        return orderUserRepository.findAll();
    }

    public void addOrderUser(OrderUser orderUser){
        orderUserRepository.save(orderUser);
    }

    public void updateOrderUser(OrderUser orderUser , Integer id){
        OrderUser orderUser1 = orderUserRepository.findOrderUserById(id);
        if(orderUser1 == null){
            throw new ApiException("OrderUser");
        }
        orderUser1.setCar(orderUser.getCar());
        orderUser1.setName(orderUser.getName());
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
}

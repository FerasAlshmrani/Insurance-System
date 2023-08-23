package com.example.insurance2.Repository;

import com.example.insurance2.Model.OrderUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderUserRepository extends JpaRepository<OrderUser,Integer> {
    OrderUser findOrderUserById(Integer id);
}

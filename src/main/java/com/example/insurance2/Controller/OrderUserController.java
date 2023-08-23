package com.example.insurance2.Controller;

import com.example.insurance2.Api.ApiResponse;
import com.example.insurance2.Model.OrderUser;
import com.example.insurance2.Service.OrderUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/order")
public class OrderUserController {
    private final OrderUserService orderUserService;

    @GetMapping("/get")
    public ResponseEntity getAllOrders(){
        return ResponseEntity.status(200).body(orderUserService.getAllOrders());
    }

    @GetMapping("/find-order/{id}")
    public ResponseEntity getOrderById(@PathVariable Integer id){
        return ResponseEntity.status(200).body(orderUserService.findOrderUserById(id));
    }

}

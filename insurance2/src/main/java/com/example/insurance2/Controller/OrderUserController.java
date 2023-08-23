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

/*    @PostMapping("/add")
    public ResponseEntity addOrder(@RequestBody @Valid OrderUser orderUser){
        orderUserService.addOrderUser(orderUser);

        return ResponseEntity.status(200).body("Order Added");
    }*/

    @PutMapping("/update/{id}")
    public ResponseEntity updateOrder(@PathVariable Integer id, @RequestBody @Valid OrderUser orderUser){
        orderUserService.updateOrderUser(orderUser, id);
        return ResponseEntity.status(200).body(new ApiResponse("Order updated"));
    }

    @PutMapping("/add-user-order/{user_id}/assign/{order_id}")
    public ResponseEntity assignUserToOrder(@PathVariable Integer user_id,@PathVariable Integer order_id){

        orderUserService.assaignOrderToUser(user_id,order_id);
        return ResponseEntity.status(200).body(new ApiResponse("assign added"));
    }

    @PutMapping("/add-insurance-order/{insurance}/assign/{order_id}")
    public ResponseEntity assignInsurancePackageToOrder(@PathVariable Integer insurancePackage_id,@PathVariable Integer order_id){

        orderUserService.assignInsurancePackageToOrder(insurancePackage_id,order_id);
        return ResponseEntity.status(200).body(new ApiResponse("assign added"));
    }


}

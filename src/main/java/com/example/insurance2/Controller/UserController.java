package com.example.insurance2.Controller;




import com.example.insurance2.Api.ApiResponse;
import com.example.insurance2.Model.User;
import com.example.insurance2.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;
    @GetMapping("/get")
    public ResponseEntity getAllUser(){
        return ResponseEntity.status(200).body(userService.getAllUser());
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody @Valid User user){
        userService.addUser(user);

        return ResponseEntity.status(200).body("User Added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id, @RequestBody @Valid User user){
        userService.updateUser(id, user);
        return ResponseEntity.status(200).body(new ApiResponse("User updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id){
        userService.removeUser(id);
        return ResponseEntity.status(200).body("User Delete");
    }

    @GetMapping("/find-users-by-role/{role}")
    public ResponseEntity getUsersByRole(@PathVariable String role){
        List<User> userList = userService.getUsersByRole(role);
        return ResponseEntity.status(200).body(userList);
    }

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity getUserById(@PathVariable Integer id){
        User user = userService.getUserById(id);
        return ResponseEntity.status(200).body(user);
    }
    @PutMapping ("/by-service/{id}/{serviceName}")
    public ResponseEntity byService(@PathVariable Integer id, @PathVariable String serviceName){
        userService.byService(id, serviceName);
        return ResponseEntity.status(200).body("Payment Done");
    }
    @PutMapping("/use-coupon/{id}/{couponCode}")
    public ResponseEntity usedCheck(@PathVariable Integer id, @PathVariable String couponCode){
        userService.useCoupon(id, couponCode);
        return ResponseEntity.status(200).body("coupon is  used");
    }
}


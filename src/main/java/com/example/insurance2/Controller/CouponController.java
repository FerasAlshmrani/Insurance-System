package com.example.insurance2.Controller;

import com.example.insurance2.Api.ApiResponse;
import com.example.insurance2.Model.Coupon;
import com.example.insurance2.Service.CouponSerivce;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RequestMapping("/api/v1/coupons")
@RequiredArgsConstructor
@RestController
public class CouponController {
    private final CouponSerivce couponservice;

    @GetMapping("/")
    public ResponseEntity getCoupons() {
        return ResponseEntity.status(HttpStatus.OK).body(couponservice.getCoupons());
    }

    @PostMapping("/add")
    public ResponseEntity addCoupon(@RequestBody @Valid Coupon coupon) {
        couponservice.addCoupon(coupon);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Coupon added"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity removeCoupon(@PathVariable Integer id) {
        couponservice.removeCoupon(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Coupon deleted"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCoupon(@PathVariable Integer id, @RequestBody @Valid Coupon coupon) {
        couponservice.update(id, coupon);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Coupon updated"));
    }

    @GetMapping("/endcoupons/{id}")
    public ResponseEntity endCoupons(@PathVariable Integer id) {
        couponservice.endCoupons(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Coupon is ended"));
    }
}
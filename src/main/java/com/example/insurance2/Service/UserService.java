package com.example.insurance2.Service;

import com.example.insurance2.Api.ApiException;
import com.example.insurance2.Model.Car;
import com.example.insurance2.Model.Coupon;
import com.example.insurance2.Model.InsurancePackage;
import com.example.insurance2.Model.User;
import com.example.insurance2.Repository.CarRepository;
import com.example.insurance2.Repository.CouponRepository;
import com.example.insurance2.Repository.InsurancePackageRepository;
import com.example.insurance2.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final CarRepository carRepository;
    private final InsurancePackageRepository insurancePackageRepository;
    private final CouponRepository couponRepository;
    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    public void addUser(User user){
        userRepository.save(user);
    }

    public void updateUser(Integer id, User user){
        User user1 = userRepository.findUserById(id);

        if (user1 == null ){
            throw new ApiException("User Id Not found");
        }

        user1.setName(user.getName());
        user1.setPhonenumber(user.getPhonenumber());
        user1.setBalance(user.getBalance());
        user1.setRole(user.getRole());
        userRepository.save(user1);
    }

    public void removeUser(Integer id){
        User user = userRepository.findUserById(id);

        if (user == null ){
            throw new ApiException("User Id Not found");
        }

        userRepository.delete(user);
    }

    public List<User> getUsersByRole(String role){
        List<User> userList = userRepository.findUserByRole(role);

        if (userList.isEmpty()){
            throw new ApiException("No User found with this Role "+role+" or this role not valid");
        }

        return userList;
    }

    public User getUserById(Integer id){
        User user = userRepository.findUserById(id);

        if (user == null ){
            throw new ApiException("Id Not found");
        }

        return user;
    }

    public void byService(Integer id, String serviceName){
        User user = userRepository.findUserById(id);
        InsurancePackage service = insurancePackageRepository.findInsurancePackageByinsurancetype(serviceName);


        if (user == null || service == null){
            throw new ApiException("User or Service Not found");
        }

        if (user.getBalance() < service.getInsurancePrice()){
            throw new ApiException("You Don not have Enough Balance");
        }


            for (Car u : user.getCar()){
                if (u.getCarModel() < 2006){
                    Double raisedPrice = service.getInsurancePrice() * 1.2;
                    Double newBlance = user.getBalance() - raisedPrice;

                    user.setBalance(newBlance);
                    userRepository.save(user);
                }
            }


            Double newBalance = user.getBalance() - service.getInsurancePrice();

            user.setBalance(newBalance);

            userRepository.save(user);

    }
    public void useCoupon(Integer id, String couponCode){
        User user = userRepository.findUserById(id);
        Coupon coupon = couponRepository.findCouponByCouponCode(couponCode);

        if (user==null){
            throw new ApiException("User Not Found");
        } else if (coupon == null) {
            throw new ApiException("No Coupon Found");
        } else if (coupon.getStatus().equals("used")) {
            throw new ApiException("Coupon is Already Used");
        } else {
            Double newBalance = user.getBalance() + coupon.getCouponPrice();
            user.setBalance(newBalance);
            coupon.setStatus("used");
            userRepository.save(user);
            couponRepository.save(coupon);
        }
    }

}

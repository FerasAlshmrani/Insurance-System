package com.example.insurance2.Service;

import com.example.insurance2.Api.ApiException;
import com.example.insurance2.Model.User;
import com.example.insurance2.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

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
}

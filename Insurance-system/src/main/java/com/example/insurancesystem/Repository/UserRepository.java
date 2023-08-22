package com.example.insurancesystem.Repository;

import com.example.insurancesystem.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findUserById(Integer id);
    List<User> findUserByRole(String role);
}


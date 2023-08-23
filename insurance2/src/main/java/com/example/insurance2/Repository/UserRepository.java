package com.example.insurance2.Repository;

import com.example.insurance2.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserById(Integer id);
    List<User> findUserByRole(String role);
}

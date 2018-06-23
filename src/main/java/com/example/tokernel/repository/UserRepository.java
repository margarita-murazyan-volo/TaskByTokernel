package com.example.tokernel.repository;


import com.example.tokernel.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findOneByEmail(String email);
}

package com.example.tokernel.repository;



import com.example.tokernel.model.Number;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NumberRepository extends JpaRepository<Number,Integer> {

}

package com.example.zomato.repository;

import com.example.zomato.entity.Cuisine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuisineRepository extends JpaRepository<Cuisine,String> {


}

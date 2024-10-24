package com.example.zomato.repository;

import com.example.zomato.entity.FoodType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodTypeRepository extends JpaRepository<FoodType, String> {

    boolean existsByTitleIgnoreCase(String title);
}

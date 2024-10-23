package com.example.zomato.repository;

import com.example.zomato.entity.MenuCategory;
import com.example.zomato.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MenuCategoryRepository extends JpaRepository<MenuCategory, String> {
   // Optional<MenuCategory> findByRestaurant(Restaurant restaurant);
}

package com.example.zomato.repository;

import aj.org.objectweb.asm.commons.Remapper;
import com.example.zomato.entity.FoodType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FoodTypeRepository extends JpaRepository<FoodType, String> {

    boolean existsByTitleIgnoreCase(String title);

    Optional<FoodType> findFoodTypeByTitle(String title);
}

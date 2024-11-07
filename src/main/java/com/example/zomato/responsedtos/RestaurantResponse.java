package com.example.zomato.responsedtos;

import com.example.zomato.enums.DietType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class RestaurantResponse {

   private String restaurantId;
   private String name;
   private String description;
   private String email;
   private String phoneNumber;
   private List<DietType> dietTypes;
   private AddressResponse addressResponse;

}

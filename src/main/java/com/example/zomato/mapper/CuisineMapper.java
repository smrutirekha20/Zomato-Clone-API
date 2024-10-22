package com.example.zomato.mapper;

import com.example.zomato.entity.Cuisine;
import com.example.zomato.requestdtos.CuisineRequest;
import com.example.zomato.responsedtos.CuisineResponse;

public class CuisineMapper {

    public Cuisine mapToCuisine(CuisineRequest cuisineRequest,Cuisine cuisine){
        cuisine.setTitle(cuisineRequest.getTitle());

        return cuisine;
    }

    public CuisineResponse mapToCuisineResponse(Cuisine cuisine){
        CuisineResponse cuisineResponse=new CuisineResponse();
        cuisineResponse.setCuisineId(cuisine.getCuisineId());
        cuisineResponse.setTitle(cuisine.getTitle());

        return cuisineResponse;

    }
}

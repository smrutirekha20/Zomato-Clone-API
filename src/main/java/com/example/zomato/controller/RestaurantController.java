package com.example.zomato.controller;

import com.example.zomato.entity.Address;
import com.example.zomato.responsedtos.RestaurantResponse;
import com.example.zomato.requestdtos.RestaurantRequest;
import com.example.zomato.service.RestaurantService;
import com.example.zomato.utility.AppResponseBuilder;
import com.example.zomato.utility.ErrorStructure;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${zomato.base_url}")
@AllArgsConstructor
public class RestaurantController {
    private RestaurantService restaurantService;
    private AppResponseBuilder appResponseBuilder;

    @Operation(description = "The end point can be used to save the data", responses =
            {
                    @ApiResponse(responseCode = "201", description = "Restaurant created"),
                    @ApiResponse(responseCode = "400", description = "invalid input", content = {
                            @Content(schema = @Schema(implementation = ErrorStructure.class))
                    })
            })
    @PostMapping("/restaurants")
    public ResponseEntity<ErrorStructure<RestaurantResponse>> addRestaurant(@RequestBody @Valid RestaurantRequest
                                                                                    restaurantRequest) {
        RestaurantResponse restaurantResponse = restaurantService.saveRestaurant(restaurantRequest);
        return appResponseBuilder.success(HttpStatus.CREATED, "Restaurant created", restaurantResponse);
    }

    @Operation(description = "The end point can be used to update the restaurant", responses =
            {
                    @ApiResponse(responseCode = "200", description = "Restaurant updated"),
                    @ApiResponse(responseCode = "404", description = "restaurant not found"),
                    @ApiResponse(responseCode = "400", description = "invalid input", content = {
                            @Content(schema = @Schema(implementation = ErrorStructure.class))
                    })
            })

    @PutMapping("/restaurants/{restaurantId}")
    public ResponseEntity<ErrorStructure<RestaurantResponse>> updateRestaurant(@RequestBody @Valid RestaurantRequest restaurantRequest, @PathVariable String restaurantId) {

        RestaurantResponse restaurantResponse = restaurantService.updateRestaurant(restaurantRequest, restaurantId);
        return appResponseBuilder.success(HttpStatus.OK, "Restaurant updated", restaurantResponse);
    }

    @Operation(description = "The end point can be used to find the restaurant", responses =
            {
                    @ApiResponse(responseCode = "302", description = "Restaurant found"),
                    @ApiResponse(responseCode = "404", description = "Restaurant not found", content = {
                            @Content(schema = @Schema(implementation = ErrorStructure.class))
                    })
            })
    @GetMapping("/restaurants/{restaurantId}")
    public ResponseEntity<ErrorStructure<RestaurantResponse>> findRestaurantById(@PathVariable @Valid String restaurantId) {
        RestaurantResponse restaurantResponse = restaurantService.findRestaurantById(restaurantId);
        return appResponseBuilder.success(HttpStatus.FOUND, "Restaurant found by given id", restaurantResponse);
    }
}


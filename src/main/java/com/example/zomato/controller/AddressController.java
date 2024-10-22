package com.example.zomato.controller;


import com.example.zomato.requestdtos.AddressRequest;
import com.example.zomato.responsedtos.AddressResponse;
import com.example.zomato.service.AddressService;
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
@AllArgsConstructor
@RequestMapping("${zomato.base_url}")
public class AddressController {

    private AddressService addressService;
    private AppResponseBuilder appResponseBuilder;

    @Operation(description = "The end point can be used to save the address", responses =
            {
                    @ApiResponse(responseCode = "201", description = "Address created"),
                    @ApiResponse(responseCode = "400", description = "invalid input", content = {
                            @Content(schema = @Schema(implementation = ErrorStructure.class))
                    })
            })
    @PostMapping("/addresses")
    public ResponseEntity<ErrorStructure<AddressResponse>> addRestaurant(@RequestBody @Valid AddressRequest addressRequest, @RequestParam String restaurantId) {
        AddressResponse addressResponse = addressService.saveAddress(addressRequest, restaurantId);
        return appResponseBuilder.success(HttpStatus.CREATED, "Address created", addressResponse);
    }

    @Operation(description = "The end point can be used to update the Address", responses =
            {
                    @ApiResponse(responseCode = "200", description = "Address updated"),
                    @ApiResponse(responseCode = "404", description = "Address not found"),
                    @ApiResponse(responseCode = "400", description = "invalid input", content = {
                            @Content(schema = @Schema(implementation = ErrorStructure.class))
                    })
            })
    @PutMapping("/addresses/{addressId}")
    public ResponseEntity<ErrorStructure<AddressResponse>> updateRestaurant(@RequestBody @Valid AddressRequest addressRequest, @PathVariable String addressId) {
        AddressResponse addressResponse = addressService.updateAddress(addressRequest, addressId);
        return appResponseBuilder.success(HttpStatus.CREATED, "Address updated", addressResponse);
    }

}

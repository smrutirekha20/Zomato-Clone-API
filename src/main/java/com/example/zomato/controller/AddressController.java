package com.example.zomato.controller;


import com.example.zomato.requestdtos.AddressRequest;
import com.example.zomato.responsedtos.AddressResponse;
import com.example.zomato.service.AddressService;
import com.example.zomato.utility.AppResponseBuilder;
import com.example.zomato.utility.ErrorStructure;
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

    @PostMapping("/addresses")
    public ResponseEntity<ErrorStructure<AddressResponse>> addRestaurant(@RequestBody AddressRequest addressRequest,@RequestParam String restaurantId) {
       AddressResponse addressResponse=addressService.saveAddress(addressRequest,restaurantId);
        return appResponseBuilder.success(HttpStatus.CREATED, "Address created", addressResponse);
    }
    @PutMapping("/addresses/{addressId}")
    public ResponseEntity<ErrorStructure<AddressResponse>> updateAddress(@RequestBody AddressRequest addressRequest,@PathVariable String addressId) {
        AddressResponse addressResponse=addressService.updateAddress(addressRequest,addressId);
        return appResponseBuilder.success(HttpStatus.CREATED, "Address updated", addressResponse);
    }

}

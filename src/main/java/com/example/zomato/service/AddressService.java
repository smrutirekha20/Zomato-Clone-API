package com.example.zomato.service;

import com.example.zomato.entity.Address;
import com.example.zomato.entity.Restaurant;
import com.example.zomato.exception.AddressNotFoundByIdException;
import com.example.zomato.exception.RestaurantNotFoundByIdException;
import com.example.zomato.mapper.AddressMapper;
import com.example.zomato.mapper.RestaurantMapper;
import com.example.zomato.repository.AddressRepository;
import com.example.zomato.repository.RestaurantRepository;
import com.example.zomato.requestdtos.AddressRequest;
import com.example.zomato.requestdtos.RestaurantRequest;
import com.example.zomato.responsedtos.AddressResponse;
import com.example.zomato.responsedtos.RestaurantResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;
    private final RestaurantRepository restaurantRepository;

    public AddressResponse saveAddress(AddressRequest addressRequest, String restaurantId) {
        Address address = addressMapper.mapToAddress(addressRequest, new Address());
        if (restaurantId != null) {
            Restaurant restaurant = restaurantRepository.findById(restaurantId)
                    .orElseThrow(() -> new RestaurantNotFoundByIdException("Restaurant not found by given id"));
            restaurant.setAddress(address);
            restaurantRepository.save(restaurant);

        }
        return addressMapper.mapToAddressResponse(address);

//        return restaurantRepository.findById(restaurantId)
//                .map(r -> {
//                    r.setAddress(addressMapper.mapToAddress(addressRequest, new Address()));
//                    restaurantRepository.save(r);
//                    return addressMapper.mapToAddressResponse(r.getAddress());
//                })
//                .orElseThrow(() -> new RestaurantNotFoundByIdException("Restaurnat not found by id"));
//

    }

    public AddressResponse findAddressById(String addressId) {

        return addressRepository.findById(addressId)
                .map(addressMapper::mapToAddressResponse)
                .orElseThrow(() -> new AddressNotFoundByIdException("Address not found by id"));
    }

    public AddressResponse updateAddress(AddressRequest addressRequest, String addressId) {

        return addressRepository.findById(addressId)
                .map(exAddress -> {
                    exAddress = addressMapper.mapToAddress(addressRequest, exAddress);
                    exAddress = addressRepository.save(exAddress);
                    return addressMapper.mapToAddressResponse(exAddress);

                })
                .orElseThrow(() -> new AddressNotFoundByIdException("Failed To Update Address"));
    }
}


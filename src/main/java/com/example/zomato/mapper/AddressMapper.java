package com.example.zomato.mapper;


import com.example.zomato.entity.Address;
import com.example.zomato.requestdtos.AddressRequest;
import com.example.zomato.responsedtos.AddressResponse;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {

    public Address mapToAddress(AddressRequest addressRequest, Address address) {
        address.setAddressLine1(addressRequest.getAddressLine1());
        address.setAddressLine2(addressRequest.getAddressLine2());
        address.setArea(addressRequest.getArea());
        address.setCity(addressRequest.getCity());
        address.setState(addressRequest.getState());
        address.setPinCode(addressRequest.getPinCode());
        address.setLandMark(addressRequest.getLandMark());
        address.setLatitude(addressRequest.getLatitude());
        address.setLongitude(addressRequest.getLongitude());

        return address;
    }

    public AddressResponse mapToAddressResponse(Address address) {
        AddressResponse addressResponse = new AddressResponse();
        addressResponse.setAddressId(address.getAddressId());
        addressResponse.setAddressLine1(address.getAddressLine1());
        addressResponse.setAddressLine2(address.getAddressLine2());
        addressResponse.setCity(address.getCity());
        addressResponse.setArea(address.getArea());
        addressResponse.setLandMark(address.getLandMark());
        addressResponse.setState(address.getState());
        addressResponse.setPinCode(address.getPinCode());
        addressResponse.setLongitude(address.getLongitude());
        addressResponse.setLatitude(address.getLatitude());

        return addressResponse;
    }

}

package com.example.zomato.responsedtos;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressResponse {

    private String addressId;
    private String addressLine1;
    private String AddressLine2;
    private String landMark;
    private String area;
    private String city;
    private String state;
    private String pinCode;
    private double latitude;
    private double longitude;
}

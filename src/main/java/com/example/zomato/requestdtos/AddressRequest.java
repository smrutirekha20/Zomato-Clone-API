package com.example.zomato.requestdtos;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class AddressRequest {

    @NotNull(message = "address line1 can not be null")
    @NotBlank(message = "address line1 can not be blank")
    private String addressLine1;

    @NotNull
    private String addressLine2;

    @NotNull(message = "land mark can not be null")
    @NotBlank(message = "land mark can not be blank")
    private String landMark;

    @NotNull(message = "area can not be not null")
    @NotBlank(message = "area can not be not blank")
    private String area;

    @NotNull(message = "city can not be null")
    @NotBlank(message = "city can not be blank")
    private String city;

    @NotNull(message = "state can not be null")
    @NotBlank(message = "state can not be blank")
    private String state;

    @NotNull(message = "pin code can not be null")
    @Pattern(regexp = "^[0-9]{6}$",message = "pin_code must be exactly 6 digit")
    private String pinCode;

    @NotNull(message = "Latitude can not be null")
    @Min(value = -90, message = "Latitude must be between -90 and 90")
    @Max(value = 90, message = "Latitude must be between -90 and 90")
    private double latitude;

    @NotNull(message = "Longitude can not be null")
    @Min(value = -180, message = "Longitude must be between -180 and 180")
    @Max(value = 180, message = "Longitude must be between -180 and 180")
    private double longitude;
}

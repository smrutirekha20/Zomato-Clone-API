package com.example.zomato.requestdtos;

import com.example.zomato.entity.Address;
import com.example.zomato.enums.DietType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;


import java.util.List;
@Data
public class RestaurantRequest {

    @NotNull(message = "Name can not be null")
    @NotBlank(message="Name can not be blank")
    @Pattern(regexp = "^[A-Z][a-zA-Z0-9_]{2,30}$",message="username must be start with uppercase and must have underscore '_'")
    private String name;

    @NotBlank(message ="description can not be blank")
    private String description;

    @Pattern(regexp = "^(?:\\+91[-\\s]?|91[-\\s]?|0)?[789]\\d{9}$\n",message="number must be ten numerics")
    private String phoneNumber;

    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@gmail\\.com$",message="email must be end with @gmail.com")
    private String email;

    @NotNull(message="dietTypes can not be not null")
    @NotBlank(message="dietTypes can not be blank")
    private List<DietType> dietTypes;


}

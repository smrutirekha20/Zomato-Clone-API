package com.example.zomato.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public enum UserRole {
    RESTAURANT_OWNER(List.of(
            Privilege.RESTAURANT_READ,
            Privilege.RESTAURANT_WRITE
    )),
    CUSTOMER(List.of(
            Privilege.READ,
            Privilege.WRITE,
            Privilege.RESTAURANT_READ
    ));

    private List<Privilege> privileges;

}

package com.example.zomato.config;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.time.Year;
import java.util.UUID;

public class CustomIdGenerator implements IdentifierGenerator {


    @Override
    public Object generate(SharedSessionContractImplementor session, Object object) {
        UUID uuid = UUID.randomUUID();
        String id = "zomato" + Year.now().toString() + uuid.toString();
        return id;
    }
}

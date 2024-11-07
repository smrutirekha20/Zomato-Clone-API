package com.example.zomato.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition
public class AppDoc {

    Info info() {
        return new Info()
                .title("Zomato-Clone-API")
                .version("v1")
                .description("Zomato-Clone-API is Restful API used to manage restaurant,address,customer details"
                        + " through the provided endpoints covering all crud oprations.");
    }

    @Bean
    OpenAPI openAPI() {

        return new OpenAPI().info(info());
    }

}

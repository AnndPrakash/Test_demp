package com.ecom.configuration;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
@OpenAPIDefinition(
    info = @Info(title = "ECOMMERCE-APPLICATION", version = "v1")
)
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        OpenAPI openApi = new OpenAPI();
        openApi.servers(Arrays.asList(
            new Server().url("http://localhost:8080").description("Local server"),
            new Server().url("http://localhost:8081").description("Test server"),
            new Server().url("http://dev.example.com").description("Development server"),
            new Server().url("https://api.example.com").description("Production server")
        ));
        return openApi;
    }
}

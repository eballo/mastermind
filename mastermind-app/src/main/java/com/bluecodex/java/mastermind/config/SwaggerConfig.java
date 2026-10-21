package com.bluecodex.java.mastermind.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI api() {
        Contact contact = new Contact().name("Blue Codex").url("www.bluecodex.com").email("enric.ballo@bluecodex.com");
        return new OpenAPI().info(new Info()
                .title("Mastermind")
                .description("Mastermind API")
                .version("1.0.0")
                .contact(contact)
                .license(new License().name("GNU license")));
    }
}

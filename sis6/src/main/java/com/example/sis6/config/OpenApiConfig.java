package com.example.sis6.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI sis6OpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("SIS 6 Book API")
                        .description("Demo API documented with Springdoc OpenAPI and Swagger UI")
                        .version("v1.0.0")
                        .contact(new Contact().name("SIS 6").email("support@example.com"))
                        .license(new License().name("Apache 2.0").url("https://www.apache.org/licenses/LICENSE-2.0")))
                .externalDocs(new ExternalDocumentation()
                        .description("Springdoc OpenAPI")
                        .url("https://springdoc.org/"));
    }
}
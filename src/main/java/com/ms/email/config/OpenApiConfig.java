package com.ms.email.config;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                ),
                description = "",
                title = "Hello Swagger OpenApi",
                version = "v1",
                license = @License(
                        name = "Licence name",
                        url = "https://some-url.com"
                )
        )
)
public class OpenApiConfig {
}

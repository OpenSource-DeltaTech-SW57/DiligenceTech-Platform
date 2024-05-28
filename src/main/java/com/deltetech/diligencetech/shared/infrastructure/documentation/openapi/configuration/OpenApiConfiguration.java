package com.deltetech.diligencetech.shared.infrastructure.documentation.openapi.configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
    @Bean
    public OpenAPI diligencetechPlatformOpenApi() {
        var openApi = new OpenAPI();
        openApi
                .info(new Info()
                        .title("DELTATECH DiligenceTech Platform API")
                        .description("DELTATECH DiligenceTech Platform application REST API documenttion")
                        .version("v1.0.0")
                        .license(new License().name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0.html")))
                .externalDocs(new ExternalDocumentation()
                        .description("DELTATECH DiligenceTech Platform Wiki Documentation")
                        .url("https://github.com/OpenSource-DeltaTech-SW57/DiligenceTech-Platform"));
        return openApi;
    }
}

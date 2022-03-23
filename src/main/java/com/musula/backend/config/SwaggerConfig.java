package com.musula.backend.config;

import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.media.StringSchema;
import io.swagger.v3.oas.models.parameters.Parameter;
import org.springdoc.core.SpringDocUtils;
import org.springdoc.core.customizers.OperationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;

/**
 * The Class represents SwaggerConfig.
 */
@Configuration
public class SwaggerConfig {


    @Bean
    public OpenAPI customOpenAPI() {
        SpringDocUtils.getConfig().replaceWithClass(org.springframework.data.domain.Pageable.class,
                org.springdoc.core.converters.models.Pageable.class);
        return new OpenAPI()
                .info(new Info().title("Drone  API")
                        .description("APIs for Drone Backend")
                        .version("v0.0.1"));
    }


}

@Component
class GlobalQueryOperationCustomizer implements OperationCustomizer {

    @Override
    public Operation customize(Operation operation, HandlerMethod handlerMethod) {
        Parameter lang = new Parameter().in(ParameterIn.QUERY.toString()).schema(new StringSchema())
                .name("lang").description("Language of the system use 'en' or 'fr'")
                .required(false);
        operation.addParametersItem(lang);
        return operation;
    }
}
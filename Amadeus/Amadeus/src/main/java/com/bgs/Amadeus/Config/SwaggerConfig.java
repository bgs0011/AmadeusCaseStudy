package com.bgs.Amadeus.Config;

import io.swagger.models.SecurityRequirement;
import io.swagger.models.auth.In;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


import java.util.Arrays;
import java.util.Collections;

@Configuration
@EnableWebMvc
public class SwaggerConfig {

}
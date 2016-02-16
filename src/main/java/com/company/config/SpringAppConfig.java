package com.company.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by himanshuk on 16/2/16.
 */
@Configuration
@ComponentScan(basePackages = {"com.company"})
@EnableWebMvc
public class SpringAppConfig {
}

package com.river.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    SimpleBean simpleBeanConfigure(){
        return new SimpleBean("RIVER" + river);
    }

    @Value("${river.value}")
    String river;
}

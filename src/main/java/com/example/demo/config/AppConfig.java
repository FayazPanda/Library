package com.example.demo.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.time.LocalTime;

@Configuration
public class AppConfig {

    @Bean
    public String time() {
        return "Hello " + LocalTime.now();
    }

    @Bean
    @Scope("prototype")
    public ModelMapper mapper() {
        return new ModelMapper();
    }

}

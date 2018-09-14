package ru.shitlin.springboot.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig  {
    @Bean(initMethod = "init")
    public TestInit testCreate() {
        return new TestInit();
    }
}

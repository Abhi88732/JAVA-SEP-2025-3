package com.SpringBootProject.Mapper;

import org.apache.catalina.mapper.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    @Bean
    public Mapper getMapper() {
        return new Mapper();
    }
}

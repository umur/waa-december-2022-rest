package edu.miu.lab2.restdemo;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public ModelMapper createModelMapper() {

        return new ModelMapper();
    }
}

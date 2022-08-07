package com.intern.secondproject.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.intern.secondproject.mapper.QueryMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {

    @Bean
    public ObjectMapper objectMapper(){
        return  new ObjectMapper();
    }


}

package com.aaron.ren.config;

import com.aaron.ren.feign.UserServiceFeignClient;
import com.aaron.ren.feign.UserServiceFeignClient02;
import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.spring.SpringContract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    public UserServiceFeignClient userServiceFeignClient() {
        return Feign.builder()
                .encoder(new GsonEncoder()) // 设置编码器
                .decoder(new GsonDecoder()) // 设置解码器
                .target(UserServiceFeignClient.class, "http://127.0.0.1:18080"); // 目标地址
    }

    @Bean
    public UserServiceFeignClient02 userServiceFeignClient02() {
        return Feign.builder()
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .contract(new SpringContract())//SpringMVC 契约
                .target(UserServiceFeignClient02.class, "http://127.0.0.1:18080"); // 目标地址
    }

}

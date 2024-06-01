package com.example.springaidemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class Config {
    @Bean
    public Function<MockWeatherService.Request, MockWeatherService.Response> getCityWeather() {
        return new MockWeatherService();
    }
}

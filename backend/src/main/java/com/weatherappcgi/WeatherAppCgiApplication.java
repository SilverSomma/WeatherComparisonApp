package com.weatherappcgi;

import com.weatherappcgi.service.AppService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;

@SpringBootApplication
public class WeatherAppCgiApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeatherAppCgiApplication.class, args);
    }


}

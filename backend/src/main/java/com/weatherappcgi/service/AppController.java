package com.weatherappcgi.service;


import com.weatherappcgi.domain.currentweather.WeatherRequestCurrentPojo;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class AppController {

    @Resource
    private AppService appService;


    @PostMapping("/accuweather")
    @Operation(summary = "Get future weather data from Accuweather.")
    public WeatherReport getAccuweather(@RequestBody WeatherRequest request) {
        return appService.getAccuweather(request);
    }

    @PostMapping("/weatherapi")
    @Operation(summary = "Get future weather data from WeatherApi.")
    public WeatherReport getWeatherApi(@RequestBody WeatherRequest request) {
        return appService.getWeatherApi(request);
    }

    @PostMapping("/current")
    @Operation(summary = "Get current weather data.")
    public WeatherReportCurrent getCurrentWeather(@RequestBody WeatherRequestCurrent request) {
        return appService.getCurrentWeather(request);
    }


}



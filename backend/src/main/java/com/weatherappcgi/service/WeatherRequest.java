package com.weatherappcgi.service;

import lombok.Data;


@Data
public class WeatherRequest {

    private String latitude;
    private String longitude;
    private String dateRange;
}

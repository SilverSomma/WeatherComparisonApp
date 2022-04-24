package com.weatherappcgi.service;

import lombok.Data;

import java.util.List;

@Data
public class WeatherReportCurrent {

    private String cityName;

    private String countryName;

    private String dateTime;

    private Double temperature;

    private Boolean rain;

    private String descriptionDay;

}










package com.weatherappcgi.service;

import lombok.Data;

import java.util.List;

@Data
public class WeatherReport {

    private String cityName;

    private String countryName;

    private List<ReportDay> weatherReportList;
}

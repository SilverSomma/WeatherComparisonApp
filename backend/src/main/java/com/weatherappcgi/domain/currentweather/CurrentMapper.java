package com.weatherappcgi.domain.currentweather;

import com.weatherappcgi.domain.accuweather.LocationKey;
import com.weatherappcgi.service.WeatherReportCurrent;
import org.springframework.stereotype.Service;

@Service
public class CurrentMapper {
    public WeatherReportCurrent currentToReportMapper(WeatherRequestCurrentPojo[] request, LocationKey locationKey) {
        WeatherReportCurrent currentWeatherReport = new WeatherReportCurrent();
        currentWeatherReport.setDateTime(request[0].getLocalObservationDateTime());
        currentWeatherReport.setTemperature(request[0].getTemperature().getMetric().getValue());
        currentWeatherReport.setRain(request[0].getHasPrecipitation());
        currentWeatherReport.setDescriptionDay(request[0].getWeatherText());
        currentWeatherReport.setCityName(locationKey.getCityName());
        currentWeatherReport.setCountryName(locationKey.getCountry().getCountryName());
        return currentWeatherReport;
    }
}

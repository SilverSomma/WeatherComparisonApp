package com.weatherappcgi.domain.accuweather;

import com.weatherappcgi.service.ReportDay;
import com.weatherappcgi.service.WeatherReport;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccuweatherMapper {
    public WeatherReport accuToReportMapper(WeatherRequestAccu request, LocationKey locationkey) {
        List<DailyForecast> dailyForecasts = request.getDailyForecasts();
        List<ReportDay> reportList = new ArrayList<>();
        WeatherReport weatherReport = new WeatherReport();
        for (DailyForecast dailyForecast : dailyForecasts) {
            ReportDay reportDay = new ReportDay();
            reportDay.setDateTime(dailyForecast.getDate());
            reportDay.setMinimumTemp(dailyForecast.getTemperature().getMinimum().getValue());
            reportDay.setMaximumTemp(dailyForecast.getTemperature().getMaximum().getValue());
            reportDay.setRain(dailyForecast.getDay().getHasPrecipitation());
            reportDay.setDescriptionDay(dailyForecast.getDay().getIconPhrase());
            reportList.add(reportDay);
        }
        weatherReport.setCityName(locationkey.getCityName());
        weatherReport.setCountryName(locationkey.getCountry().getCountryName());
        weatherReport.setWeatherReportList(reportList);
        return weatherReport;
    }
}

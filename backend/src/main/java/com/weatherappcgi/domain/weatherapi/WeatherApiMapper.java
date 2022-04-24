package com.weatherappcgi.domain.weatherapi;

import com.weatherappcgi.service.ReportDay;
import com.weatherappcgi.service.WeatherReport;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WeatherApiMapper {
    public WeatherReport weatherApiToReportMapper(WeatherRequestApi request) {
        WeatherReport fullReport = new WeatherReport();
        List<Forecastday> requestList = request.getForecast().getForecastday();
        List<ReportDay> reportList = new ArrayList<>();
        for (Forecastday forecastday : requestList) {
            ReportDay reportDay = new ReportDay();
            reportDay.setDateTime(forecastday.getDate());
            reportDay.setMinimumTemp(forecastday.getDay().getMintempC());
            reportDay.setMaximumTemp(forecastday.getDay().getMaxtempC());
            if (forecastday.getDay().getDailyWillItRain() == 1) {
                reportDay.setRain(true);

            } else {
                reportDay.setRain(false);

            }
            reportDay.setDescriptionDay(forecastday.getDay().getCondition().getText());
            reportList.add(reportDay);
        }

        fullReport.setWeatherReportList(reportList);
        fullReport.setCityName(request.getLocation().getRegion());
        fullReport.setCountryName(request.getLocation().getCountry());
        return fullReport;
    }
}

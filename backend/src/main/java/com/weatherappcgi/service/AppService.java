package com.weatherappcgi.service;

import com.weatherappcgi.domain.accuweather.AccuweatherMapper;
import com.weatherappcgi.domain.accuweather.LocationKey;
import com.weatherappcgi.domain.accuweather.WeatherRequestAccu;
import com.weatherappcgi.domain.currentweather.CurrentMapper;
import com.weatherappcgi.domain.currentweather.WeatherRequestCurrentPojo;
import com.weatherappcgi.domain.weatherapi.WeatherApiMapper;
import com.weatherappcgi.domain.weatherapi.WeatherRequestApi;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
public class AppService {

    @Resource
    private AccuweatherMapper accuweatherMapper;
    @Resource
    private WeatherApiMapper weatherApiMapper;
    @Resource
    private CurrentMapper currentMapper;

    private final RestTemplate restTemplate;


    public AppService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }


    public WeatherReport getAccuweather(WeatherRequest request) {
        LocationKey locationKey = getLocationHttp(request.getLatitude(), request.getLongitude());
        String key = locationKey.getKey();
        String date = request.getDateRange();
        String url = "http://dataservice.accuweather.com/forecasts/v1/daily/" + date + "day/" + key + "?apikey=tAZGAwAAcEDWF9A3HcMefz089tqyhdRe&language=en&details=false&metric=true";
        WeatherRequestAccu weatherRequestAccu = this.restTemplate.getForObject(url, WeatherRequestAccu.class);
        return accuweatherMapper.accuToReportMapper(weatherRequestAccu, locationKey);
    }

    public WeatherReport getWeatherApi(WeatherRequest request) {
        String date = request.getDateRange();
        String latitude = request.getLatitude();
        String longitude = request.getLongitude();
        String url = "http://api.weatherapi.com/v1/forecast.json?key=5e048bfeecb5462cb1f75921221904&q=" + latitude + "," + longitude + "&days=" + date + "&aqi=no&alerts=no";
        WeatherRequestApi weatherRequestApi = this.restTemplate.getForObject(url, WeatherRequestApi.class);
        return weatherApiMapper.weatherApiToReportMapper(weatherRequestApi);
    }


    public WeatherReportCurrent getCurrentWeather(WeatherRequestCurrent request) {
        LocationKey locationKey = getLocationHttp(request.getLatitude(), request.getLongitude());
        String key = locationKey.getKey();
        String url = "http://dataservice.accuweather.com/currentconditions/v1/" + key + "?apikey=tAZGAwAAcEDWF9A3HcMefz089tqyhdRe&language=en&details=false";

        WeatherRequestCurrentPojo[] weatherRequestCurrentPojos = this.restTemplate.getForObject(url, WeatherRequestCurrentPojo[].class);
        return currentMapper.currentToReportMapper(weatherRequestCurrentPojos, locationKey);
    }


    private LocationKey getLocationHttp(String latitute, String longitute) {
        String url = "http://dataservice.accuweather.com/locations/v1/cities/geoposition/search?apikey=tAZGAwAAcEDWF9A3HcMefz089tqyhdRe&q=" + latitute + "," + longitute + "&language=en&details=false&toplevel=true";
        return this.restTemplate.getForObject(url, LocationKey.class);
    }


}



package com.weatherappcgi.domain.accuweather;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LocationKey {
    @JsonProperty ("Key")
    private String key;
    @JsonProperty ("EnglishName")
    private String cityName;
    @JsonProperty ("Country")
    private Country country;
}

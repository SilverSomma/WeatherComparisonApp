package com.weatherappcgi.domain.accuweather;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Country {
    @JsonProperty("EnglishName")
    private String countryName;
}

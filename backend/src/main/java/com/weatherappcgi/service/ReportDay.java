package com.weatherappcgi.service;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;

@Data
public class ReportDay {

    private String dateTime;

    private Double minimumTemp;

    private Double maximumTemp;

    private Boolean rain;

    private String descriptionDay;


}
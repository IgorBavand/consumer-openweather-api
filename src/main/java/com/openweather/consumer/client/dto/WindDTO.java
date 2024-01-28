package com.openweather.consumer.client.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WindDTO {
    private double speed;
    private int deg;
    private double gust;
}
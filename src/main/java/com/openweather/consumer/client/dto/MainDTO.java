package com.openweather.consumer.client.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MainDTO {
    private Double temp;
    private Double feels_like;
    private Double temp_min;
    private Double temp_max;
    private Integer sea_level;
    private Integer pressure;
    private Integer humidity;
}
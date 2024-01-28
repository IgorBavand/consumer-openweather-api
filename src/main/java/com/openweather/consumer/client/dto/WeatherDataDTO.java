package com.openweather.consumer.client.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeatherDataDTO {
    private CoordDTO coord;
    private MainDTO main;
    private WindDTO wind;
    private CloudsDTO clouds;
    private SysDTO sys;
    private long dt;
    private Integer visibility;
    private Integer id;
    private String name;
    private Integer cod;
}
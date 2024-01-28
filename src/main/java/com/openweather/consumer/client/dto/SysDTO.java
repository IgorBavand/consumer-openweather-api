package com.openweather.consumer.client.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SysDTO {
    private String country;
    private long sunrise;
    private long sunset;

}
package com.openweather.consumer.client;

import com.openweather.consumer.client.dto.WeatherDataDTO;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;

@FeignClient(
    name = "open-weather",
    url = "https://api.openweathermap.org/data/2.5/weather"
)
public interface OpenWeatherClient {

    @GetMapping()
    public WeatherDataDTO buscarDados(@RequestParam String q, @RequestParam String appid);


}

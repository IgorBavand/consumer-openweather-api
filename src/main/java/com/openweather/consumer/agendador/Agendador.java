package com.openweather.consumer.agendador;

import com.openweather.consumer.service.CidadeService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Agendador {

    private final CidadeService service;

    @Scheduled(fixedDelay = 900000)
    public void agendadorTempoCapitaisSul() {
        service.salvarDadosCapitaisSul();
    }

}

package com.openweather.consumer.controller;

import com.openweather.consumer.client.dto.WeatherDataDTO;
import com.openweather.consumer.service.CidadeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class CidadeController {

    private final CidadeService service;

    @GetMapping("buscar-dados-cidade")
    public ResponseEntity<WeatherDataDTO> salvarDados(String nomeCidade) {
        return ResponseEntity.ok().body(service.buscarDadosCidade(nomeCidade));
    }
}

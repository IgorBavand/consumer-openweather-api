package com.openweather.consumer.service;

import com.openweather.consumer.client.OpenWeatherClient;
import com.openweather.consumer.client.dto.WeatherDataDTO;
import com.openweather.consumer.model.Cidade;
import com.openweather.consumer.repository.CidadeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CidadeService {

    private final OpenWeatherClient openWeatherClient;
    private final CidadeRepository cidadeRepository;

    @Value("${api-config.key-openweather}")
    private String key;

    public WeatherDataDTO buscarDadosCidade(String nomeCidade) {
        return openWeatherClient.buscarDados(nomeCidade, key);
    }

    public void salvarDadosCapitaisSul() {
        List<String> capitais = List.of("curitiba", "florianopolis", "porto alegre");
        capitais.forEach(this::salvarDadosCidade);
    }

    private void salvarDadosCidade(String cidade) {
        try {

            var response = openWeatherClient.buscarDados(cidade, key);

            var save = Cidade.builder()
                .nome(response.getName())
                .temperatura(converterGrausEmcelcius(response.getMain().getTemp()))
                .maxima(converterGrausEmcelcius(response.getMain().getTemp_max()))
                .minima(converterGrausEmcelcius(response.getMain().getTemp_min()))
                .sensacao(converterGrausEmcelcius(response.getMain().getFeels_like()))
                .umidade(response.getMain().getHumidity())
                .nivelMar(response.getMain().getSea_level())
                .data(LocalDateTime.now())
                .build();

            cidadeRepository.save(save);

        } catch (Exception ex) {
            throw new RuntimeException("Erro interno do sistema.");
        }
    }

    private Double converterGrausEmcelcius(Double grausKelvin) {
        return (grausKelvin - 273.15);
    }

}

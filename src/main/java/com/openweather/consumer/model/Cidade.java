package com.openweather.consumer.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "cidades")
@Builder
@Entity
@EnableJpaAuditing
public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private Double temperatura;
    private Double sensacao;
    private Double minima;
    private Double maxima;
    private Integer umidade;
    @Column(name = "nivel_mar")
    private Integer nivelMar;
    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime data;
}

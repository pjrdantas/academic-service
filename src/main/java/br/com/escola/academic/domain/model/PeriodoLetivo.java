package br.com.escola.academic.domain.model;

import java.time.LocalDate;
import java.util.UUID;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PeriodoLetivo {

    private UUID id;
    private Integer ano;
    private Integer semestre;
    private LocalDate dataInicio;
    private LocalDate dataFim;
}
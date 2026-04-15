package br.com.escola.academic.adapter.out.persistence.entity;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "periodo_letivo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PeriodoLetivoEntity {

    @Id
    private UUID id;

    @Column(name="ano")
    private Integer ano;

    @Column(name="semestre")
    private Integer semestre;

    @Column(name="data_inicio")
    private LocalDate dataInicio;

    @Column(name="data_fim")
    private LocalDate dataFim;
}
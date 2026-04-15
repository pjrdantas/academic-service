package br.com.escola.academic.domain.model;

import java.util.UUID;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class Matricula {

    private UUID id;
    private UUID alunoId;
    private UUID turmaId;
    private UUID periodoLetivoId;

    public static Matricula create(
            UUID alunoId,
            UUID turmaId,
            UUID periodoLetivoId
    ) {
        return Matricula.builder()
                .id(UUID.randomUUID())
                .alunoId(alunoId)
                .turmaId(turmaId)
                .periodoLetivoId(periodoLetivoId)
                .build();
    }



}
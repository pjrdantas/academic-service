package br.com.escola.academic.domain.model;

import java.util.UUID;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
public class Turma {

    private UUID id;
    private int capacidade;
    private int totalAlunos;

    public Turma(UUID id, int capacidade, int totalAlunos) {
        this.id = id;
        this.capacidade = capacidade;
        this.totalAlunos = totalAlunos;
    }

    public Matricula matricularAluno(UUID alunoId, UUID periodoLetivoId) {

        if (totalAlunos >= capacidade) {
            throw new RuntimeException("Turma cheia");
        }

        this.totalAlunos++;

        return Matricula.create(alunoId, this.id, periodoLetivoId);
    }

    public UUID getId() {
        return id;
    }
}
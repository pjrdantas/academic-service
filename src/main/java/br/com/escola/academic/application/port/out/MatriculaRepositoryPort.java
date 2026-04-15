package br.com.escola.academic.application.port.out;

import java.util.UUID;

import br.com.escola.academic.domain.model.Matricula;

public interface MatriculaRepositoryPort {
    void salvar(Matricula matricula);
    boolean existsByAlunoIdAndPeriodoLetivoId(UUID alunoId, UUID periodoLetivoId);
}
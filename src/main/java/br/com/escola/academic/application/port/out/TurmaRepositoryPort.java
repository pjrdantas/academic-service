package br.com.escola.academic.application.port.out;

import java.util.UUID;

public interface TurmaRepositoryPort {
    boolean existsById(UUID turmaId);
    int contarAlunos(UUID turmaId);
    int buscarCapacidade(UUID turmaId);
}
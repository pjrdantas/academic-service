package br.com.escola.academic.application.port.out;

import java.util.UUID;

public interface AlunoRepositoryPort {

    boolean existsById(UUID alunoId);
}
package br.com.escola.academic.application.port.in;

import java.util.UUID;

public interface MatricularAlunoUseCase {

    UUID executar(UUID alunoId, UUID turmaId, UUID periodoLetivoId);

}
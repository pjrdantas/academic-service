package br.com.escola.academic.application.port.out;

import java.util.Optional;
import java.util.UUID;

import br.com.escola.academic.domain.model.PeriodoLetivo;

public interface PeriodoLetivoRepositoryPort {

    boolean existsById(UUID id);

    boolean isPeriodoValido(UUID id);

    Optional<PeriodoLetivo> buscarPorId(UUID id);
}
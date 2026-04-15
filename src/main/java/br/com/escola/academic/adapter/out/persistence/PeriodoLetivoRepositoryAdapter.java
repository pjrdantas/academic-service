package br.com.escola.academic.adapter.out.persistence;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import br.com.escola.academic.adapter.out.persistence.mapper.PeriodoLetivoMapper;
import br.com.escola.academic.adapter.out.persistence.repository.SpringDataPeriodoLetivoRepository;
import br.com.escola.academic.application.port.out.PeriodoLetivoRepositoryPort;
import br.com.escola.academic.domain.model.PeriodoLetivo;

@Repository
public class PeriodoLetivoRepositoryAdapter implements PeriodoLetivoRepositoryPort {

    private final SpringDataPeriodoLetivoRepository repository;

    public PeriodoLetivoRepositoryAdapter(SpringDataPeriodoLetivoRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean existsById(UUID id) {
        return repository.existsById(id);
    }

    @Override
    public boolean isPeriodoValido(UUID id) {
        return repository.findById(id)
                .map(entity -> {
                    LocalDate hoje = LocalDate.now();
                    return entity.getDataInicio() != null
                            && entity.getDataFim() != null
                            && !hoje.isBefore(entity.getDataInicio())
                            && !hoje.isAfter(entity.getDataFim());
                })
                .orElse(false);
    }

    @Override
    public Optional<PeriodoLetivo> buscarPorId(UUID id) {
        return repository.findById(id)
                .map(PeriodoLetivoMapper::toDomain);
    }
}
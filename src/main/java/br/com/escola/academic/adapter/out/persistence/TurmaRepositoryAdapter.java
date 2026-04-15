package br.com.escola.academic.adapter.out.persistence;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import br.com.escola.academic.adapter.out.persistence.repository.SpringDataTurmaRepository;
import br.com.escola.academic.application.port.out.TurmaRepositoryPort;

@Repository
public class TurmaRepositoryAdapter implements TurmaRepositoryPort {

    private final SpringDataTurmaRepository repository;

    public TurmaRepositoryAdapter(SpringDataTurmaRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean existsById(UUID id) {
        return repository.existsById(id);
    }
    
    @Override
    public int contarAlunos(UUID turmaId) {
        return repository.countByTurmaId(turmaId);
    }

    @Override
    public int buscarCapacidade(UUID turmaId) {
        Integer capacidade = repository.findCapacidadeById(turmaId);

        if (capacidade == null) {
            throw new RuntimeException("Turma não encontrada");
        }

        return capacidade;
    }
}
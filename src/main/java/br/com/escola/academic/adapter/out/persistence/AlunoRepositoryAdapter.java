package br.com.escola.academic.adapter.out.persistence;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import br.com.escola.academic.application.port.out.AlunoRepositoryPort;
import br.com.escola.academic.adapter.out.persistence.repository.SpringDataAlunoRepository;

@Repository
public class AlunoRepositoryAdapter implements AlunoRepositoryPort {

    private final SpringDataAlunoRepository repository;

    public AlunoRepositoryAdapter(SpringDataAlunoRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean existsById(UUID alunoId) {
        return repository.existsById(alunoId);
    }
}
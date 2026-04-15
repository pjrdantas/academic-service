package br.com.escola.academic.adapter.out.persistence;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import br.com.escola.academic.adapter.out.persistence.mapper.MatriculaMapper;
import br.com.escola.academic.adapter.out.persistence.repository.SpringDataMatriculaRepository;
import br.com.escola.academic.application.port.out.MatriculaRepositoryPort;
import br.com.escola.academic.domain.model.Matricula;

@Repository
public class MatriculaRepositoryAdapter implements MatriculaRepositoryPort {

    private final SpringDataMatriculaRepository repository;

    public MatriculaRepositoryAdapter(SpringDataMatriculaRepository repository) {
        this.repository = repository;
    }

    @Override
    public void salvar(Matricula matricula) {
        repository.save(MatriculaMapper.toEntity(matricula));
    }
    
    @Override
    public boolean existsByAlunoIdAndPeriodoLetivoId(UUID alunoId, UUID periodoLetivoId) {
        return repository.existsByAlunoIdAndPeriodoLetivoId(alunoId, periodoLetivoId);
    }
}
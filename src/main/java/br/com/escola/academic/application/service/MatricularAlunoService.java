package br.com.escola.academic.application.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.escola.academic.application.port.in.MatricularAlunoUseCase;
import br.com.escola.academic.application.port.out.AlunoRepositoryPort;
import br.com.escola.academic.application.port.out.MatriculaRepositoryPort;
import br.com.escola.academic.application.port.out.PeriodoLetivoRepositoryPort;
import br.com.escola.academic.application.port.out.TurmaRepositoryPort;
import br.com.escola.academic.domain.exception.AlunoNaoEncontradoException;
import br.com.escola.academic.domain.exception.PeriodoLetivoNaoEncontradoException;
import br.com.escola.academic.domain.model.Matricula;
import br.com.escola.academic.domain.model.PeriodoLetivo;
import br.com.escola.academic.domain.service.MatriculaDomainService;



@Service
public class MatricularAlunoService implements MatricularAlunoUseCase {

	private final AlunoRepositoryPort alunoRepository;
    private final MatriculaRepositoryPort matriculaRepository;
    private final TurmaRepositoryPort turmaRepository;
    private final PeriodoLetivoRepositoryPort periodoRepository;
    private final MatriculaDomainService domainService;

    public MatricularAlunoService(
            MatriculaRepositoryPort matriculaRepository,
            TurmaRepositoryPort turmaRepository,
            PeriodoLetivoRepositoryPort periodoRepository,
            AlunoRepositoryPort alunoRepository,
            MatriculaDomainService domainService) {

        this.matriculaRepository = matriculaRepository;
        this.turmaRepository = turmaRepository;
        this.periodoRepository = periodoRepository;
        this.alunoRepository = alunoRepository;
        this.domainService = domainService;
    }

    @Override
    public UUID executar(UUID alunoId, UUID turmaId, UUID periodoLetivoId) {
    		
    	
    	boolean alunoExiste = alunoRepository.existsById(alunoId);

    	if (!alunoExiste) {
    	    throw new AlunoNaoEncontradoException();
    	}

        boolean periodoExiste = periodoRepository.existsById(periodoLetivoId);

        PeriodoLetivo periodo = periodoRepository.buscarPorId(periodoLetivoId)
                .orElseThrow(PeriodoLetivoNaoEncontradoException::new);

        boolean jaMatriculado =
                matriculaRepository.existsByAlunoIdAndPeriodoLetivoId(alunoId, periodoLetivoId);

        int totalAlunos = turmaRepository.contarAlunos(turmaId);
        int capacidade = turmaRepository.buscarCapacidade(turmaId);

        boolean periodoValido = domainService.isPeriodoValido(periodo);

        domainService.validar(
                periodoExiste,
                periodoValido,
                jaMatriculado,
                totalAlunos,
                capacidade
        );

        Matricula matricula = Matricula.create(alunoId, turmaId, periodoLetivoId);

        matriculaRepository.salvar(matricula);

        return matricula.getId();
    }
}
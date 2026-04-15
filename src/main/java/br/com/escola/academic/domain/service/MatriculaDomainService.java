package br.com.escola.academic.domain.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import br.com.escola.academic.domain.exception.MatriculaDuplicadaException;
import br.com.escola.academic.domain.exception.PeriodoInvalidoException;
import br.com.escola.academic.domain.exception.PeriodoLetivoNaoEncontradoException;
import br.com.escola.academic.domain.exception.TurmaLotadaException;
import br.com.escola.academic.domain.model.PeriodoLetivo;

@Service
public class MatriculaDomainService {

    public void validar(
            boolean periodoExiste,
            boolean periodoValido,
            boolean jaMatriculado,
            int totalAlunos,
            int capacidade
    ) {

        if (!periodoExiste) {
            throw new PeriodoLetivoNaoEncontradoException();
        }

        if (!periodoValido) {
            throw new PeriodoInvalidoException();
        }

        if (jaMatriculado) {
            throw new MatriculaDuplicadaException();
        }

        if (totalAlunos >= capacidade) {
            throw new TurmaLotadaException();
        }
    }
    
    public boolean isPeriodoValido(PeriodoLetivo periodo) {
        LocalDate hoje = LocalDate.now();

        return periodo.getDataInicio() != null
                && periodo.getDataFim() != null
                && !hoje.isBefore(periodo.getDataInicio())
                && !hoje.isAfter(periodo.getDataFim());
    }
}
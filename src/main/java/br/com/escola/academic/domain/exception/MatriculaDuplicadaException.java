package br.com.escola.academic.domain.exception;

public class MatriculaDuplicadaException extends BusinessException {

	private static final long serialVersionUID = 1L;

	public MatriculaDuplicadaException() {
        super("Aluno já matriculado no período");
    }
}
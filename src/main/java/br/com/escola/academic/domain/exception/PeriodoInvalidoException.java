package br.com.escola.academic.domain.exception;

public class PeriodoInvalidoException extends BusinessException {

	private static final long serialVersionUID = 1L;

	public PeriodoInvalidoException() {
        super("Período letivo inválido");
    }
}
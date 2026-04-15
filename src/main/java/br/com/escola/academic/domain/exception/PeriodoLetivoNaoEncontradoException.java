package br.com.escola.academic.domain.exception;

public class PeriodoLetivoNaoEncontradoException extends BusinessException {

	private static final long serialVersionUID = 1L;

	public PeriodoLetivoNaoEncontradoException() {
        super("Período letivo não encontrado");
    }
}
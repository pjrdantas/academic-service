package br.com.escola.academic.domain.exception;

public class TurmaLotadaException extends BusinessException {

	private static final long serialVersionUID = 1L;

	public TurmaLotadaException() {
        super("Turma está cheia");
    }
}
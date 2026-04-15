package br.com.escola.academic.domain.exception;

public class AlunoNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AlunoNaoEncontradoException() {
        super("Aluno não encontrado");
    }
}
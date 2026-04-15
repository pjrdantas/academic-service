package br.com.escola.academic.adapter.in.web.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.escola.academic.domain.exception.AlunoNaoEncontradoException;
import br.com.escola.academic.domain.exception.BusinessException;
import br.com.escola.academic.domain.exception.PeriodoLetivoNaoEncontradoException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(org.hibernate.exception.ConstraintViolationException.class)
	public ResponseEntity<?> handleConstraintViolation(ConstraintViolationException ex) {

	    return ResponseEntity.status(HttpStatus.CONFLICT).body(
	            "Violação de chave estrangeira"
	    );
	}
	
    @ExceptionHandler(AlunoNaoEncontradoException.class)
    public ResponseEntity<?> handleAlunoNaoEncontrado() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Aluno não encontrado");
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> handleBusiness(
            BusinessException ex,
            HttpServletRequest request) {

        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new ErrorResponse(
                        LocalDateTime.now(),
                        409,
                        "CONFLICT",
                        ex.getMessage(),
                        request.getRequestURI()
                ));
    }

    @ExceptionHandler(PeriodoLetivoNaoEncontradoException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(
            PeriodoLetivoNaoEncontradoException ex,
            HttpServletRequest request) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(
                        LocalDateTime.now(),
                        404,
                        "NOT_FOUND",
                        ex.getMessage(),
                        request.getRequestURI()
                ));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneric(
            Exception ex,
            HttpServletRequest request) {

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorResponse(
                        LocalDateTime.now(),
                        500,
                        "INTERNAL_SERVER_ERROR",
                        "Erro interno inesperado",
                        request.getRequestURI()
                ));
    }
}
package br.com.escola.academic.application.dto;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;

public record MatriculaRequest(
		@NotNull UUID alunoId, 
		@NotNull UUID turmaId, 
		@NotNull UUID periodoLetivoId
		) 
{}
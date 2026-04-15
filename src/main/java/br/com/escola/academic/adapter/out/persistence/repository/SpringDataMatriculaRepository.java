package br.com.escola.academic.adapter.out.persistence.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.escola.academic.adapter.out.persistence.entity.MatriculaEntity;

public interface SpringDataMatriculaRepository
extends JpaRepository<MatriculaEntity, UUID> {
	boolean existsByAlunoIdAndPeriodoLetivoId(UUID alunoId, UUID periodoLetivoId);
	
	
}
package br.com.escola.academic.adapter.out.persistence.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "matricula")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MatriculaEntity {

	@Id
    private UUID id;

	@Column(name="aluno_id")
    private UUID alunoId;
	
	@Column(name="turma_id")
    private UUID turmaId;

	@Column(name = "periodo_letivo_id", nullable = false)
	private UUID periodoLetivoId;
    
}
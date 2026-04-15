package br.com.escola.academic.adapter.out.persistence.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.escola.academic.adapter.out.persistence.entity.TurmaEntity;

public interface SpringDataTurmaRepository extends JpaRepository<TurmaEntity, UUID> {

    @Query("SELECT COUNT(m) FROM MatriculaEntity m WHERE m.turmaId = :turmaId")
    int countByTurmaId(@Param("turmaId") UUID turmaId);

    @Query("SELECT t.capacidade FROM TurmaEntity t WHERE t.id = :turmaId")
    Integer findCapacidadeById(@Param("turmaId") UUID turmaId);
}
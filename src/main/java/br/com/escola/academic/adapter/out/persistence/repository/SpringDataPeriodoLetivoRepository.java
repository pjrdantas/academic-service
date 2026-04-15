package br.com.escola.academic.adapter.out.persistence.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.escola.academic.adapter.out.persistence.entity.PeriodoLetivoEntity;

public interface SpringDataPeriodoLetivoRepository extends JpaRepository<PeriodoLetivoEntity, UUID> {
}
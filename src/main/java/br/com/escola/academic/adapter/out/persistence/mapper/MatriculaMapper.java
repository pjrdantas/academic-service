package br.com.escola.academic.adapter.out.persistence.mapper;

import br.com.escola.academic.adapter.out.persistence.entity.MatriculaEntity;
import br.com.escola.academic.domain.model.Matricula;

public class MatriculaMapper {

    public static MatriculaEntity toEntity(Matricula domain) {
        MatriculaEntity entity = new MatriculaEntity();
        entity.setId(domain.getId());
        entity.setAlunoId(domain.getAlunoId());
        entity.setTurmaId(domain.getTurmaId());
        entity.setPeriodoLetivoId(domain.getPeriodoLetivoId());
        return entity;
    }
}
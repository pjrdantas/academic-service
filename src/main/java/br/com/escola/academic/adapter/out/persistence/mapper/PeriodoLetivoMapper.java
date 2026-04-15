package br.com.escola.academic.adapter.out.persistence.mapper;

import br.com.escola.academic.adapter.out.persistence.entity.PeriodoLetivoEntity;
import br.com.escola.academic.domain.model.PeriodoLetivo;

public class PeriodoLetivoMapper {

    public static PeriodoLetivo toDomain(PeriodoLetivoEntity entity) {
        if (entity == null) return null;

        return PeriodoLetivo.builder()
                .id(entity.getId())
                .ano(entity.getAno())
                .semestre(entity.getSemestre())
                .dataInicio(entity.getDataInicio())
                .dataFim(entity.getDataFim())
                .build();
    }

    public static PeriodoLetivoEntity toEntity(PeriodoLetivo domain) {
        if (domain == null) return null;

        return PeriodoLetivoEntity.builder()
                .id(domain.getId())
                .ano(domain.getAno())
                .semestre(domain.getSemestre())
                .dataInicio(domain.getDataInicio())
                .dataFim(domain.getDataFim())
                .build();
    }
}
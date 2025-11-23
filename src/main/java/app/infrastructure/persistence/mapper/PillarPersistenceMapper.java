package app.infrastructure.persistence.mapper;

import app.domain.model.Pillar;
import app.infrastructure.persistence.entities.PillarEntity;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class PillarPersistenceMapper {

    
    public PillarEntity toEntity(Pillar domain) {
        if (domain == null) return null;

        PillarEntity entity = new PillarEntity();
        entity.setId(domain.getId());
        entity.setName(domain.getName());
        entity.setPosX(domain.getPosX());
        entity.setPosY(domain.getPosY());
        entity.setStatus(domain.getStatus());

        return entity;
    }

    
    public Pillar toDomain(PillarEntity entity) {
        if (entity == null) return null;

        return new Pillar(
                entity.getId(),
                entity.getName(),
                entity.getPosX(),
                entity.getPosY(),
                entity.getStatus()
        );
    }
}

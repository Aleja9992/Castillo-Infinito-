package app.infrastructure.persistence.mapper;

import app.domain.model.TacticalMessage;
import app.infrastructure.persistence.entities.TacticalMessageEntity;
import org.springframework.stereotype.Component;

@Component 
public class TacticalMessagePersistenceMapper {

    
    public TacticalMessageEntity toEntity(TacticalMessage domain) {
        if (domain == null) return null;

        TacticalMessageEntity entity = new TacticalMessageEntity();
        entity.setId(domain.getId());
        entity.setPillarId(domain.getPillarId());
        entity.setFragmentedContent(domain.getFragmentedContent());
        entity.setReconstructedContent(domain.getReconstructedContent());
        entity.setTimestamp(domain.getTimestamp());

        return entity;
    }

  
    public TacticalMessage toDomain(TacticalMessageEntity entity) {
        if (entity == null) return null;

        return new TacticalMessage(
                entity.getId(),
                entity.getPillarId(),
                entity.getFragmentedContent(),
                entity.getReconstructedContent(),
                entity.getTimestamp()
        );
    }
}

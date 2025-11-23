package app.adapter.rest.mapper;

import app.infrastructure.persistence.entities.TacticalMessageEntity;
import app.domain.model.TacticalMessage;
import org.springframework.stereotype.Component;

@Component
public class MessageMapper {

    public TacticalMessage toDomain(TacticalMessageEntity e) {
        if (e == null) return null;
        return new TacticalMessage(
                e.getId(),
                e.getPillarId(),
                e.getFragmentedContent(),
                e.getReconstructedContent(),
                e.getTimestamp()
        );
    }

    public TacticalMessageEntity toEntity(TacticalMessage m) {
        if (m == null) return null;
        
        TacticalMessageEntity e = new TacticalMessageEntity();
        
        e.setId(m.getId());
        e.setPillarId(m.getPillarId());
        e.setFragmentedContent(m.getFragmentedContent());
        e.setReconstructedContent(m.getReconstructedContent());
        e.setTimestamp(m.getTimestamp());
        return e;
    }
}

package app.adapter.out.persistence;

import app.domain.model.TacticalMessage;
import app.domain.ports.MessageRepositoryPort;
import app.infrastructure.persistence.entities.TacticalMessageEntity;
import app.infrastructure.persistence.mapper.TacticalMessagePersistenceMapper;
import app.infrastucture.persistence.repository.TacticalMessageRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TacticalMessageAdapter implements MessageRepositoryPort {

    private final TacticalMessageRepository jpa;    
    private final TacticalMessagePersistenceMapper mapper;      

    public TacticalMessageAdapter(TacticalMessageRepository jpa,
                                  TacticalMessagePersistenceMapper mapper) {
        this.jpa = jpa;
        this.mapper = mapper;
    }

    @Override
    public TacticalMessage save(TacticalMessage message) {

        TacticalMessageEntity entity = mapper.toEntity(message);

        TacticalMessageEntity saved = jpa.save(entity);

        return mapper.toDomain(saved);
    }

    @Override
    public Optional<TacticalMessage> findById(Long id) {

        Optional<TacticalMessageEntity> entityOpt = jpa.findById(id);

        if (!entityOpt.isPresent()) {
            return Optional.empty();
        }

        TacticalMessage message = mapper.toDomain(entityOpt.get());

        return Optional.of(message);
    }
}

package app.domain.ports;

import app.domain.model.TacticalMessage;
import java.util.Optional;

public interface MessageRepositoryPort {
    TacticalMessage save(TacticalMessage message);
    Optional<TacticalMessage> findById(Long id);
}

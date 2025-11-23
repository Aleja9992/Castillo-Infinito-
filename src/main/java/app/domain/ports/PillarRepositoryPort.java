package app.domain.ports;

import app.domain.model.Pillar;
import java.util.Optional;

public interface PillarRepositoryPort {
    Optional<Pillar> findById(Long id);
    Pillar save(Pillar pillar);
    Iterable<Pillar> findAll();
}

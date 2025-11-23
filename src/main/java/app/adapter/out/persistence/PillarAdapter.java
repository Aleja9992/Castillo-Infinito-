package app.adapter.out.persistence;

import app.adapter.rest.mapper.PillarMapper;
import app.domain.model.Pillar;
import app.domain.ports.PillarRepositoryPort;
import app.infrastructure.persistence.entities.PillarEntity;
import app.infrastucture.persistence.repository.PillarRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PillarAdapter implements PillarRepositoryPort {

    private final PillarRepository jpa;
    private final PillarMapper mapper;

    public PillarAdapter(PillarRepository jpa, PillarMapper mapper) {
        this.jpa = jpa;
        this.mapper = mapper;
    }

    @Override
    public Optional<Pillar> findById(Long id) {
        return jpa.findById(id).map(mapper::toDomain);
    }

    @Override
    public Pillar save(Pillar pillar) {
        PillarEntity entity = mapper.toEntity(pillar);
        PillarEntity saved = jpa.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Iterable<Pillar> findAll() {
        return mapper.toDomainList(jpa.findAll());
    }
}

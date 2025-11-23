package app.infrastucture.persistence.repository;

import app.infrastructure.persistence.entities.PillarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PillarRepository extends JpaRepository<PillarEntity, Long> {
}


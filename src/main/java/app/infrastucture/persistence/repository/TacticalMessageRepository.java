package app.infrastucture.persistence.repository;


import app.infrastructure.persistence.entities.TacticalMessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TacticalMessageRepository extends JpaRepository<TacticalMessageEntity, Long> {
}

package app.application.Usecase;

import app.adapter.in.rest.response.PillarResponse;
import app.domain.ports.PillarRepositoryPort;
import app.application.exceptions.ResourceNotFoundException;
import app.domain.model.Pillar;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetPillarUseCase {

    private final PillarRepositoryPort repository;

    public GetPillarUseCase(PillarRepositoryPort repository) {
        this.repository = repository;
    }

    public PillarResponse getPillarById(Long id) {

        
        Optional<Pillar> optional = repository.findById(id);

        if (!optional.isPresent()) {
            throw new ResourceNotFoundException("Pilar no existe con id " + id);
        }

        Pillar p = optional.get();

        
        return new PillarResponse(
                p.getId(),
                p.getName(),
                p.getPosX(),
                p.getPosY(),
                p.getStatus()
        );
    }
}

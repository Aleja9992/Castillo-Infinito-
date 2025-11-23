package app.application.Usecase;

import app.adapter.in.rest.request.UpdatePillarPositionRequest;
import app.adapter.in.rest.response.PillarResponse;
import app.domain.ports.PillarRepositoryPort;
import app.adapter.in.validators.UpdatePillarPositionValidator;
import app.application.exceptions.ResourceNotFoundException;
import app.domain.model.Pillar;
import java.util.Map;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class UpdatePillarPositionUseCase {

    private final PillarRepositoryPort repository;
    private final UpdatePillarPositionValidator validator;

    public UpdatePillarPositionUseCase(PillarRepositoryPort repository,
                                       UpdatePillarPositionValidator validator) {
        this.repository = repository;
        this.validator = validator;
    }

    public Object updatePosition(UpdatePillarPositionRequest request) {

      
        validator.validate(request);

        Optional<Pillar> optional = repository.findById(request.getPillarId());
        if (!optional.isPresent()) {
            throw new ResourceNotFoundException("Pilar no encontrado");
        }

        Pillar pillar = optional.get();

       
        pillar.setPosX(request.getPosX());
        pillar.setPosY(request.getPosY());
        pillar.setStatus(request.getStatus());

      
        Pillar saved = repository.save(pillar);

        PillarResponse response = new PillarResponse(
                saved.getId(),
                saved.getName(),
                saved.getPosX(),
                saved.getPosY(),
                saved.getStatus()
        );

        return Map.of(
                "mensaje", "Posición actualizada exitosamente.",
                "pilar", response
        );
    }
}

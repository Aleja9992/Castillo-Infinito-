package app.application.Usecase;

import app.adapter.in.rest.request.ReconstructMessageRequest;
import app.adapter.in.rest.response.TacticalMessageResponse;
import app.application.exceptions.ResourceNotFoundException;
import app.domain.ports.MessageRepositoryPort;
import app.domain.model.TacticalMessage;
import app.domain.services.ReconstructionService;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class ReconstructMessageUseCase {

    private final MessageRepositoryPort repository;
    private final ReconstructionService reconstructionService;

    public ReconstructMessageUseCase(MessageRepositoryPort repository,
                                     ReconstructionService reconstructionService) {
        this.repository = repository;
        this.reconstructionService = reconstructionService;
    }

    public TacticalMessageResponse reconstruct(Long id, ReconstructMessageRequest request) {

        Optional<TacticalMessage> optional = repository.findById(id);
        if (!optional.isPresent()) {
            throw new ResourceNotFoundException("Mensaje no encontrado");
        }

        TacticalMessage message = optional.get();

        
        if (request.getReconstructedContent() == null || request.getReconstructedContent().isBlank()) {
            String auto = reconstructionService.reconstruct(message.getFragmentedContent());
            message.setReconstructedContent(auto);
        } else {
            message.setReconstructedContent(request.getReconstructedContent());
        }

      
        TacticalMessage saved = repository.save(message);

        return new TacticalMessageResponse(
                saved.getId(),
                saved.getPillarId(),
                saved.getFragmentedContent(),
                saved.getReconstructedContent(),
                saved.getTimestamp()
        );
    }
}

package app.application.Usecase;

import app.adapter.in.rest.request.RegisterMessageRequest;
import app.adapter.in.rest.response.TacticalMessageResponse;
import app.domain.ports.MessageRepositoryPort;
import app.domain.model.TacticalMessage;
import app.adapter.in.validators.RegisterMessageValidator;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class SaveMessageUseCase {

    private final MessageRepositoryPort repository;
    private final RegisterMessageValidator validator;

    public SaveMessageUseCase(MessageRepositoryPort repository,
                              RegisterMessageValidator validator) {
        this.repository = repository;
        this.validator = validator;
    }

    public TacticalMessageResponse save(RegisterMessageRequest request) {

        validator.validate(request);

        TacticalMessage msg = new TacticalMessage(
                null,
                request.getPillarId(),
                request.getFragmentedContent(),
                null,                       
                LocalDateTime.now()         
        );

        TacticalMessage saved = repository.save(msg);
       
        return new TacticalMessageResponse(
                saved.getId(),
                saved.getPillarId(),
                saved.getFragmentedContent(),
                saved.getReconstructedContent(),
                saved.getTimestamp()
        );
    }
}

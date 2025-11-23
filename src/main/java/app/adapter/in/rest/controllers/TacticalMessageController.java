package app.adapter.in.rest.controllers;

import app.adapter.in.rest.request.RegisterMessageRequest;
import app.adapter.in.rest.request.ReconstructMessageRequest;
import app.adapter.in.rest.response.TacticalMessageResponse;
import app.application.Usecase.ReconstructMessageUseCase;
import app.application.Usecase.SaveMessageUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/messages")
public class TacticalMessageController {

    private final SaveMessageUseCase saveMessageUseCase;
    private final ReconstructMessageUseCase reconstructMessageUseCase;

    public TacticalMessageController(SaveMessageUseCase saveMessageUseCase,
                                     ReconstructMessageUseCase reconstructMessageUseCase) {
        this.saveMessageUseCase = saveMessageUseCase;
        this.reconstructMessageUseCase = reconstructMessageUseCase;
    }

    @PostMapping
    public ResponseEntity<TacticalMessageResponse> registerMessage(@RequestBody RegisterMessageRequest request) {
        TacticalMessageResponse response = saveMessageUseCase.save(request);
        return ResponseEntity.status(201).body(response);
    }

    @PutMapping("/{id}/reconstruct")
    public ResponseEntity<TacticalMessageResponse> reconstructMessage(@PathVariable Long id,
                                                                      @RequestBody ReconstructMessageRequest request) {
        TacticalMessageResponse response = reconstructMessageUseCase.reconstruct(id, request);
        return ResponseEntity.ok(response);
    }
}


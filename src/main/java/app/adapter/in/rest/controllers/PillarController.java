package app.adapter.in.rest.controllers;

import app.adapter.in.rest.response.PillarResponse;
import app.adapter.in.rest.request.UpdatePillarPositionRequest;
import app.application.Usecase.GetPillarUseCase;
import app.application.Usecase.UpdatePillarPositionUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pillars")
public class PillarController {

    private final GetPillarUseCase getPillarUseCase;
    private final UpdatePillarPositionUseCase updatePillarPositionUseCase;

    public PillarController(GetPillarUseCase getPillarUseCase,
                            UpdatePillarPositionUseCase updatePillarPositionUseCase) {
        this.getPillarUseCase = getPillarUseCase;
        this.updatePillarPositionUseCase = updatePillarPositionUseCase;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PillarResponse> getPillar(@PathVariable Long id) {
        return ResponseEntity.ok(getPillarUseCase.getPillarById(id));
    }

    @PostMapping("/update-position")
    public ResponseEntity<?> updatePosition(@RequestBody UpdatePillarPositionRequest request) {
        return ResponseEntity.status(201).body(updatePillarPositionUseCase.updatePosition(request));
    }
}



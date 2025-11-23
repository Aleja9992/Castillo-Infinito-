package app.adapter.in.rest.controllers;

import app.adapter.in.rest.response.TriangulationResponse;
import app.application.Usecase.GetTriangulationUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/intelligence")
public class TriangulationController {

    private final GetTriangulationUseCase triangulationUseCase;

    public TriangulationController(GetTriangulationUseCase triangulationUseCase) {
        this.triangulationUseCase = triangulationUseCase;
    }

    @GetMapping("/triangulation")
    public ResponseEntity<TriangulationResponse> getTriangulation() {
        return ResponseEntity.ok(triangulationUseCase.calculateTriangulation());
    }
}

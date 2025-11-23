package app.application.Usecase;

import app.adapter.in.rest.response.TriangulationResponse;
import app.domain.ports.PillarRepositoryPort;
import app.domain.model.Pillar;
import app.domain.services.TriangulationService;
import app.application.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetTriangulationUseCase {

    private PillarRepositoryPort repository;
    private TriangulationService triangulationService;

    public GetTriangulationUseCase(PillarRepositoryPort repository,
                                   TriangulationService triangulationService) {
        this.repository = repository;
        this.triangulationService = triangulationService;
    }

    public TriangulationResponse calculateTriangulation() {
        Iterable<Pillar> pillars = repository.findAll();
        List<Pillar> list = new ArrayList<>();
        pillars.forEach(list::add);

       
        if (list.isEmpty()) {
            throw new ResourceNotFoundException("No hay pilares registrados para calcular la triangulación.");
        }

        return triangulationService.estimate(list);
    }
}

package app.domain.services;

import app.adapter.in.rest.response.TriangulationResponse;
import app.domain.model.Pillar;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TriangulationService {

    /**
     * Simple estimation accepted by the document.
     * Uses average of the pillars' coordinates.
     */
    public TriangulationResponse estimate(List<Pillar> pillars) {

        TriangulationResponse resp = new TriangulationResponse();

        if (pillars == null || pillars.isEmpty()) {
            // Valid response but without data
            resp.setPossibleMuzanPosition(new TriangulationResponse.Point(0, 0));
            resp.setConfidenceLevel(0.0);
            resp.setDescription("No hay suficientes datos para realizar la estimación.");
            return resp;
        }

        double sumX = 0;
        double sumY = 0;
        int count = 0;

        for (Pillar p : pillars) {
            if (p.getPosX() != null && p.getPosY() != null) {
                sumX += p.getPosX();
                sumY += p.getPosY();
                count++;
            }
        }

        if (count == 0) {
            resp.setPossibleMuzanPosition(new TriangulationResponse.Point(0, 0));
            resp.setConfidenceLevel(0.0);
            resp.setDescription("No se encontraron coordenadas válidas.");
            return resp;
        }

        int x = (int) Math.round(sumX / count);
        int y = (int) Math.round(sumY / count);

        resp.setPossibleMuzanPosition(new TriangulationResponse.Point(x, y));
        resp.setConfidenceLevel(0.75);
        resp.setDescription("Estimación simple basada en el promedio de las coordenadas de los pilares.");

        return resp;
    }
}

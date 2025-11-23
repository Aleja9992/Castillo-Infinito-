package app.adapter.in.validators;

import org.springframework.stereotype.Component;
import app.adapter.in.rest.request.UpdatePillarPositionRequest;
import app.application.exceptions.InvalidDataException;

@Component
public class UpdatePillarPositionValidator {

    public void validate(UpdatePillarPositionRequest request) {

        if (request == null) 
            throw new InvalidDataException("La solicitud no puede ser nula");

        if (request.getPillarId() == null) 
            throw new InvalidDataException("PillarId requerido");

        if (request.getPosX() == null || request.getPosY() == null)
            throw new InvalidDataException("posX y posY son requeridas");

        if (request.getStatus() != null && request.getStatus().trim().isEmpty())
            throw new InvalidDataException("El estado no puede estar vacio");

        if (request.getPosX() < -2000 || request.getPosX() > 2000)
            throw new InvalidDataException("posX valor fuera del rango permitido");

        if (request.getPosY() < -2000 || request.getPosY() > 2000)
            throw new InvalidDataException("posY valor fuera del rango permitido");
    }
}

package app.adapter.rest.mapper;

import app.domain.model.Pillar;
import app.infrastructure.persistence.entities.PillarEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PillarMapper {

    public Pillar toDomain(PillarEntity e) {
        if (e == null) return null;
        Pillar p = new Pillar(e.getId(), e.getName(), e.getPosX(), e.getPosY(), e.getStatus());
        return p;
    }

    public PillarEntity toEntity(Pillar p) {
        if (p == null) return null;
        PillarEntity e = new PillarEntity();
        e.setId(p.getId());
        e.setName(p.getName());
        e.setPosX(p.getPosX());
        e.setPosY(p.getPosY());
        e.setStatus(p.getStatus());
        return e;
    }

    public List<Pillar> toDomainList(Iterable<PillarEntity> all) {
        List<Pillar> list = new ArrayList<>();
        all.forEach(e -> list.add(toDomain(e)));
        return list;
    }
}

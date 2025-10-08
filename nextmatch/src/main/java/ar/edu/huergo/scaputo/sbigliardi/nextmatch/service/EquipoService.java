package ar.edu.huergo.scaputo.sbigliardi.nextmatch.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.huergo.scaputo.sbigliardi.nextmatch.dto.EquipoDTO;
import ar.edu.huergo.scaputo.sbigliardi.nextmatch.entity.Equipo;

@Service
public class EquipoService {

    private final List<Equipo> equipos = new ArrayList<>();

    public EquipoService() {
        equipos.add(new Equipo(2L, "River Plate", 436));
        equipos.add(new Equipo(1L, "Boca Juniors", 435));
        equipos.add(new Equipo(3L, "Racing Club", 437));
    }

    public List<EquipoDTO> getEquipos() {
        List<EquipoDTO> dtoList = new ArrayList<>();
        for (Equipo e : equipos) {
            dtoList.add(new EquipoDTO(e.getId(), e.getNombre(), e.getApiId()));
        }
        return dtoList;
    }

    public Equipo getEquipoPorId(Long id) {
        return equipos.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}


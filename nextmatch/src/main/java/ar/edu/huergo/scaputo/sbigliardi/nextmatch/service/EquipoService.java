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
        // Hardcodeamos 3 equipos con sus apiId (ejemplo)
        equipos.add(new Equipo("Boca Juniors", 435));
        equipos.add(new Equipo("River Plate", 436));
        equipos.add(new Equipo("Racing Club", 437));
    }

    public List<EquipoDTO> getEquipos() {
        List<EquipoDTO> dtoList = new ArrayList<>();
        for (Equipo e : equipos) {
            dtoList.add(new EquipoDTO(null, e.getNombre(), e.getApiId()));
        }
        return dtoList;
    }

    public Equipo getEquipoPorNombre(String nombre) {
        return equipos.stream()
                .filter(e -> e.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null);
    }

    public Equipo getEquipoPorId(int index) {
        if (index < 0 || index >= equipos.size()) return null;
        return equipos.get(index);
    }
}

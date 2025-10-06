package ar.edu.huergo.scaputo.sbigliardi.nextmatch.mapper;

import ar.edu.huergo.scaputo.sbigliardi.nextmatch.dto.EquipoDTO;
import ar.edu.huergo.scaputo.sbigliardi.nextmatch.entity.Equipo;

public class EquipoMapper {

    public static EquipoDTO toDTO(Equipo equipo) {
        return new EquipoDTO(
                equipo.getId(),
                equipo.getNombre()
        );
    }

    public static Equipo toEntity(EquipoDTO dto) {
        return new Equipo(
                dto.getId(),
                dto.getNombre()
        );
    }
}

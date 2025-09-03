package ar.edu.huergo.scaputo.nextmatch.mapper.equipo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.edu.huergo.scaputo.nextmatch.dto.equipo.CrearActualizarEquipoDTO;
import ar.edu.huergo.scaputo.nextmatch.dto.equipo.MostrarEquipoDTO;
import ar.edu.huergo.scaputo.nextmatch.entity.equipo.Equipo;

// Un Mapper es una clase que se encarga de convertir un objeto de un tipo a otro.
// En este caso, se encarga de convertir un objeto Equipo a un objeto EquipoDTO y viceversa.
// Esto es útil para evitar que el controlador se encargue de la conversión de objetos.
@Component
public class EquipoMapper {

    public Equipo toEntity(CrearActualizarEquipoDTO dto) {
        if (dto == null) {
            return null;
        }
        Equipo equipo = new Equipo();
        equipo.setNombre(dto.getNombre());
        equipo.setDescripcion(dto.getDescripcion());
        equipo.setPrecio(dto.getPrecio());
        return equipo;
    }

    public MostrarEquipoDTO toDTO(Equipo equipo) {
        if (equipo == null) {
            return null;
        }
        MostrarEquipoDTO dto = new MostrarEquipoDTO();
        dto.setId(equipo.getId());
        dto.setNombre(equipo.getNombre());
        dto.setDescripcion(equipo.getDescripcion());
        dto.setPrecio(equipo.getPrecio());
        return dto;
    }

    public List<MostrarEquipoDTO> toDTOList(List<Equipo> equipos) {
        if (equipos == null) {
            return new ArrayList<>();
        }
        return equipos.stream().map(this::toDTO).collect(Collectors.toList());
    }
}

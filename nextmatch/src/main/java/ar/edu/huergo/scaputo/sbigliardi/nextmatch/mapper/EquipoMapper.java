package ar.edu.huergo.scaputo.sbigliardi.nextmatch.mapper;

import org.springframework.stereotype.Component;
import ar.edu.huergo.scaputo.sbigliardi.nextmatch.dto.EquipoDTO;
import ar.edu.huergo.scaputo.sbigliardi.nextmatch.entity.Equipo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//Un Mapper es una clase que se encarga de convertir un objeto de un tipo a otro.
//En este caso, se encarga de convertir un objeto Plato a un objeto PlatoDTO y viceversa.
//Esto es útil para evitar que el controlador se encargue de la conversión de objetos.
@Component
public class EquipoMapper {

    /**
     * Convierte una entidad Plato a PlatoDTO
     */
    public EquipoDTO toDTO(Equipo equipo) {
        if (equipo == null) {
            return null;
        }
        return new EquipoDTO(
            equipo.getId(),
            equipo.getNombre()
        );
    }

    /**
     * Convierte un PlatoDTO a entidad Plato
     */
    public Equipo toEntity(EquipoDTO dto) {
        if (dto == null) {
            return null;
        }
        Equipo equipo = new Equipo();
        equipo.setNombre(dto.nombre());
        return equipo;
    }

    /**
     * Convierte una lista de entidades Plato a lista de PlatoDTO
     */
    public List<EquipoDTO> toDTOList(List<Equipo> equipos) {
        if (equipos == null) {
            return new ArrayList<>();
        }
        return equipos.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}
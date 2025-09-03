package ar.edu.huergo.scaputo.nextmatch.mapper.equipo;

import org.springframework.stereotype.Component;

import ar.edu.huergo.scaputo.nextmatch.dto.equipo.IngredienteDTO;
import ar.edu.huergo.scaputo.nextmatch.entity.equipo.Ingrediente;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//Un Mapper es una clase que se encarga de convertir un objeto de un tipo a otro.
//En este caso, se encarga de convertir un objeto Plato a un objeto PlatoDTO y viceversa.
//Esto es útil para evitar que el controlador se encargue de la conversión de objetos.
@Component
public class IngredienteMapper {

    /**
     * Convierte una entidad Plato a PlatoDTO
     */
    public IngredienteDTO toDTO(Ingrediente ingrediente) {
        if (ingrediente == null) {
            return null;
        }
        return new IngredienteDTO(
            ingrediente.getId(),
            ingrediente.getNombre()
        );
    }

    /**
     * Convierte un PlatoDTO a entidad Plato
     */
    public Ingrediente toEntity(IngredienteDTO dto) {
        if (dto == null) {
            return null;
        }
        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setNombre(dto.nombre());
        return ingrediente;
    }

    /**
     * Convierte una lista de entidades Plato a lista de PlatoDTO
     */
    public List<IngredienteDTO> toDTOList(List<Ingrediente> ingredientes) {
        if (ingredientes == null) {
            return new ArrayList<>();
        }
        return ingredientes.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}
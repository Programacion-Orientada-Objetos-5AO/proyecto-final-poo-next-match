package ar.edu.huergo.scaputo.sbigliardi.nextmatch.mapper;

import org.springframework.stereotype.Component;
import ar.edu.huergo.scaputo.sbigliardi.nextmatch.dto.RefugioDTO;
import ar.edu.huergo.scaputo.sbigliardi.nextmatch.entity.Refugio;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
//Un Mapper es una clase que se encarga de convertir un objeto de un tipo a otro.
//En este caso, se encarga de convertir un objeto Plato a un objeto PlatoDTO y viceversa.
//Esto es útil para evitar que el controlador se encargue de la conversión de objetos.
@Component
public class RefugioMapper {
    /**
    * Convierte una entidad Plato a PlatoDTO
    */
    public RefugioDTO toDTO(Refugio refugio) {
    if (refugio == null) {
    return null;
    }
    return new RefugioDTO(
    refugio.getId(),
    refugio.getNombre(),
    refugio.getEdad()
    );
}
    /**
    * Convierte un PlatoDTO a entidad Plato
    */
    public Refugio toEntity(RefugioDTO dto) {
    if (dto == null) {

    return null;
    }
    Refugio refugio = new Refugio();
    refugio.setNombre(dto.nombre());
    refugio.setEdad(dto.edad());
    return refugio;

}
/**
* Convierte una lista de entidades Plato a lista de PlatoDTO
*/
    public List<RefugioDTO> toDTOList(List<Refugio> refugios) {
    if (refugios == null) {
    return new ArrayList<>();
    }
    return refugios.stream()
    .map(this::toDTO)
    .collect(Collectors.toList());
    }
}